package com.lgg.nticxs.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lgg.nticxs.utils.Settings;
import com.lgg.nticxs.utils.WSLogger;
import com.lgg.nticxs.web.DAO.LotCardDAO;
import com.lgg.nticxs.web.DAO.UserDAO;
import com.lgg.nticxs.web.helper.ES3Helper;
import com.lgg.nticxs.web.helper.ES4Helper;
import com.lgg.nticxs.web.helper.SRHelper;
import com.lgg.nticxs.web.model.LotCard;
import com.lgg.nticxs.web.model.SimpleCard;

//import com.movasim.dp.DAO.PresetCommandDAO;
//import com.movasim.dp.model.PresetCommand;
//import com.movasim.dp.utils.Utils;
//import com.movasim.dp.ws.generated.POL2RuleActionType;
//import com.movasim.dp.ws.generated.POL2RuleQualificationType;
//import com.movasim.dp.ws.generated.POL2RuleSubjectType;
//import com.movasim.dp.ws.generated.POL2RuleType;
//
//import com.movasim.sr.DAO.CampaignDAO;
//import com.movasim.sr.DAO.CardDAO;
//import com.movasim.sr.DAO.SRDAO;
//import com.movasim.sr.model.Campaign;
//import com.movasim.sr.model.Card;
//import com.movasim.sr.model.CardProfile;
//import com.movasim.sr.model.SR;
//import com.movasim.sr.ws.generated.EISType;
//import com.movasim.sr.ws.generated.EISType.AdditionalProperties;
//import com.movasim.sr.ws.generated.PropertyType;


import com.lgg.nticxs.web.model.SimpleProfileCard;
import com.lgg.nticxs.web.model.User;

/**
 * Created by movasim on 05/09/16.
 */
@Controller
public class EuiccController {
//	private CampaignDAO campaigndao=new CampaignDAO();
//	private PresetCommandDAO presetdao= new PresetCommandDAO();
	private SRHelper srHelper= new SRHelper();
//	private CardDAO cardao=new CardDAO();
//	private SRDAO srdao=new SRDAO();
	private LotCardDAO lotcarddao = new LotCardDAO();
	private UserDAO userdao = new UserDAO();
	
	private static WSLogger logger = new WSLogger();

    @GetMapping("home/euicc/search")
    public String search(Model model) {
    	addDpName(model);
    	
    	logger.logger("INFO", "SM-WEB", "eUICC", "", "", "search()", "", "", "", "The screen of eUICC search opens");
    	
        return "euicc_search";
    }

    @PostMapping("home/euicc/search")
    public String doEuiccInfoUpload(Model model, 
    		@RequestParam("file") MultipartFile file,
    		@RequestParam(name="dpname", required=false) String dpname,
    		@RequestParam(name="srname", required=false) String srname) {
        String fileName = null;

        if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(Settings.getInstance().getFILE_UPLOAD_PATH_CARDS() + fileName)));
                buffStream.write(bytes);
                buffStream.close();

                // Process
//                JAXBContext context = JAXBContext.newInstance(EISType.class);
//                Unmarshaller unmarshaller = context.createUnmarshaller();
                
                //unmarshaller.setProperty(UnmarshallerProperties.UNMARSHALLING_CASE_INSENSITIVE, Boolean.TRUE);
//                EISType eis = (EISType) unmarshaller.unmarshal(new FileInputStream(Settings.getInstance().getFILE_UPLOAD_PATH_CARDS() + fileName));
//                
//                bleachingProfiles(Utils.toUnformattedHexArray(eis.getEumSignedInfo().getEid()));
//                PropertyType proper= new PropertyType();
//                proper.setKey("srname");
//                proper.setValue(srname);
//                AdditionalProperties prop= new AdditionalProperties();
//                prop.getProperty().add(proper);
//                eis.setAdditionalProperties(prop);
//                
//                ES1Helper.registerEis(eis);
//                
//                logger.logger("INFO", "SM-WEB", "eUICC", "", "Upload eUICC", "doEuiccInfoUpload()", "", "", 
//                		"DP name: " + dpname + ", SR name: " + srname, 
//                		"EID Reload: "+Utils.toUnformattedHexArray(eis.getEumSignedInfo().getEid()));
//                
//                campaigndao.settingsCampaing(Utils.toUnformattedHexArray(eis.getEumSignedInfo().getEid()));
//                	
//                logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Upload eUICC", "doEuiccInfoUpload()", "", "", 
//            			"DP name: " + dpname + ", SR name: " + srname, 
//            			"You have successfully uploaded");
//                
                model.addAttribute("msg2", "You have successfully uploaded");
                addDpName(model);
                return "euicc_search";
            } catch (Exception e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                
                logger.logger("ERROR", "SM-WEB", "eUICC", "", "Upload eUICC", "doEuiccInfoUpload()", "", "", 
                		"DP name: " + dpname + ", SR name: " + srname,
                		"You failed to upload: " + errors.toString());
                
                model.addAttribute("msg2", "You failed to upload: " + errors.toString());
                addDpName(model);
                return "euicc_search";
            }
        } else {
        	logger.logger("WARNING", "SM-WEB", "eUICC", "", "Upload eUICC", "doEuiccInfoUpload()", "", "", 
        			"DP name: " + dpname + ", SR name: " + srname, 
        			"Unable to upload. File is empty.");
        	
            model.addAttribute("msg2", "Unable to upload. File is empty.");
            addDpName(model);
            return "euicc_search";
        }
    }
    
    @GetMapping("home/euicc/results")
    public String resultSearch(Model model) {
        return "euicc_search";
    }
    
    @PostMapping("home/euicc/results")
    public String results(Model model,
    		Authentication auth,
    		@RequestParam("searchText") String searchText, 
    		@RequestParam("searchBy") String searchBy) {
//    	
//        List<com.movasim.sr.model.Card> cards = null;
//        User user = userdao.retrieveByName(auth.getName());
//
//        if (searchBy.compareTo(EuiccSearch.SEARCH_BY_EID) == 0) {
//            cards = cardao.searchByEid(searchText);
//        } else if (searchBy.compareTo(EuiccSearch.SEARCH_BY_MSISDN) == 0) {
//            cards = cardao.searchByMsisdn(searchText);
//        } else if (searchBy.compareTo(EuiccSearch.SEARCH_BY_ICCID) == 0) {
//            cards = cardao.searchByIccid(searchText);
//        } else if (searchBy.compareTo(EuiccSearch.SEARCH_BY_IMSI) == 0) {
//            cards = cardao.searchByImsi(searchText);
//        } else {
//            cards = cardao.retrieve();
//        }

        List<SimpleCard> simpleCards = new ArrayList<SimpleCard>();
        
//        loadCardForLotView(user, cards, simpleCards);

        model.addAttribute("cardsFound", simpleCards);
        
        logger.logger("INFO", "SM-WEB", "eUICC", "", "Search eUICC", "results()", "", "", 
        		"Search text: " + searchText + ", Search by: " + searchBy, 
        		"Search eUICC, only those that the user can see are shown");
        
        return "euicc_results";
    }

    @GetMapping("home/euicc/commands/{eid}")
    public String commands(Model model, @PathVariable String eid, Authentication auth) {
//    	com.movasim.sr.model.Card card = cardao.retrieveByEid(eid);
//        SimpleCard simpleCard = new SimpleCard(card);
//        User user = userdao.retrieveByName(auth.getName());
//        
//        Boolean edit = editCardForLotEdit(card, user);
//        
//        model.addAttribute("card", simpleCard);
//        model.addAttribute("fallbackstatus", srHelper.FallbackEnabled(eid));
//        model.addAttribute("edit", edit);
//        
//        logger.logger("INFO", "SM-WEB", "eUICC", "", "Edit eUICC", "commands()", Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid()), "", 
//        		"EID eUICC: " + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid()), 
//        		"Shows a screen where edit a specific eUICC");
        
        return "euicc_commands";
    }

    @PostMapping("home/euicc/commands/{eid}")
    public String doCommands(Model model, 
    		@PathVariable String eid, 
    		@RequestParam("action") String action,
    		@RequestParam(name="iccid", required=false) String iccid, 
    		@RequestParam(name="quantity", required=false) String quantity) {
//    	Card card = cardao.retrieveByEid(eid);
//        CardProfile profile = card.getProfileByIccid(iccid);
//
//        SimpleCard simpleCard = new SimpleCard(card);
//        model.addAttribute("card", simpleCard);
//
//        String cardWithProfileEnabled;
//        if (!CampaignHelper.isAnyOperationRunning(eid)) {
//            if (action.compareTo("enable") == 0) {
//            	if (profile.getState().equals(CardProfile.PROFILE_STATE_ENABLED)) {
//            		model.addAttribute("msg", "Profile is already enabled");
//            		
//            		logger.logger("WARNING", "SM-WEB", "eUICC", "", "Edit eUICC", "doCommands()", eid, iccid, 
//            				"EID eUICC: " + eid + ", ICCID eUICC: " + iccid,
//            				"Profile is already enabled");
//            		
//            	} else if ( (cardWithProfileEnabled = findProfileEnabledInOtherCard(iccid)) != null) {
//            		model.addAttribute("msg", "Cannot enable it. Profile is already enabled in card:" + cardWithProfileEnabled);
//            		
//            		logger.logger("ERROR", "SM-WEB", "eUICC", "", "Edit eUICC", "doCommands()", eid, iccid, 
//            				"EID eUICC: " + eid + ", ICCID eUICC: " + iccid, 
//            				"Cannot enable it. Profile is already enabled in card: " + cardWithProfileEnabled);
//            		
//            	} else {
//            		// Web service call
//            		ES2Helper.enableProfile(eid, iccid, card.getSmsrId());
//            		//model.addAttribute("msg", "IPP is being enabled");
//            		dormir();
//            		
//            		logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Edit eUICC", "doCommands()", eid, iccid, 
//            				"EID eUICC: " + eid + ", ICCID eUICC: " + iccid,  
//            				"Profile enable successfully");
//            		
//            		return "redirect:/home/euicc/commands/" + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid());
//            	}
//            } else if (action.compareTo("disable") == 0) {
//            	if (profile.getState().equals(CardProfile.PROFILE_STATE_DISABLED) || profile.getState().equals(CardProfile.PROFILE_STATE_CREATED)) {
//            		model.addAttribute("msg", "Profile is already disabled");
//            		
//            		logger.logger("WARNING", "SM-WEB", "eUICC", "", "Edit eUICC", "doCommands()", eid, iccid, 
//            				"EID eUICC: " + eid + ", ICCID eUICC: " + iccid, 
//            				"Profile is already disabled");
//            		
//            	} else {
//            		// Web service call
//            		ES2Helper.disableProfile(eid, iccid, card.getSmsrId());
//            		//model.addAttribute("msg", "IPP is being disabled");
//            		dormir();
//            		
//            		logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Edit eUICC", "doCommands()", eid, iccid, 
//            				"EID eUICC: " + eid + ", ICCID eUICC: " + iccid,
//            				"Disabled profile successfully");
//            		
//            		return "redirect:/home/euicc/commands/" + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid());
//            	}
//            } else if (action.compareTo("delete") == 0) {
//            	if (profile.isFallbackAttribute()) {
//            		model.addAttribute("msg", "Profile has Fall-back attribute set. Cannot delete");
//            		
//            		logger.logger("ERROR", "SM-WEB", "eUICC", "", "Edit eUICC", "doCommands()", eid, iccid, 
//            				"EID eUICC: " + eid + ", ICCID eUICC: " + iccid, 
//            				"Profile has Fall-back attribute set. Cannot delete");
//            		
//            	} else if (profile.getState().equals(CardProfile.PROFILE_STATE_ENABLED)) {
//            		model.addAttribute("msg", "Profile is enabled. Cannot delete it");
//            		
//            		logger.logger("ERROR", "SM-WEB", "eUICC", "", "Edit eUICC", "doCommands()", eid, iccid, 
//            				"EID eUICC: " + eid + ", ICCID eUICC: " + iccid, 
//            				"Profile is enabled. Cannot delete it");
//            		
//            	} else {
//            		// Web service call
//            		ES2Helper.deleteProfile(eid, iccid, card.getSmsrId());
//            		//model.addAttribute("msg", "IPP is being deleted");
//            		dormir();
//            		
//            		logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Edit eUICC", "doCommands()", eid, iccid,
//            				"EID eUICC: " + eid + ", ICCID eUICC: " + iccid,
//            				"Delete profile successfully");
//            		
//            		return "redirect:/home/euicc/commands/" + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid());
//            	}
//            }else if (action.compareTo("setfallbackattribute") == 0) {
//            	// Web service call
//        		ES3Helper.setFallbackAttribute(eid, iccid);
//        		dormir();
//        		
//        		logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Edit eUICC", "doCommands()", eid, iccid, 
//        				"EID eUICC: " + eid + ", ICCID eUICC: " + iccid, 
//        				"Set fallback Attribute successfully");
//        		
//        		return "redirect:/home/euicc/commands/" + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid());
//            }else if (action.compareTo("setemergencyprofile") == 0) {
//            	// Web service call
//        		ES3Helper.setEmergencyProfile(eid, iccid);
//        		dormir();
//        		
//        		logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Edit eUICC", "doCommands()", eid, iccid, 
//        				"EID eUICC: " + eid + ", ICCID eUICC: " + iccid, 
//        				"Set emergency profile to the eUICC successfully");
//        		
//        		return "redirect:/home/euicc/commands/" + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid());
//            }else if(action.compareTo("setStatusNumber") == 0){
//            	ES3Helper.statusNumberFallback(eid, quantity);
//            	dormir();
//        		return "redirect:/home/euicc/commands/" + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid());
//            }else if(action.compareTo("updatePol2") == 0){
//            	dormir();
//            	return "redirect:/home/euicc/update/pol2/" + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid())+"/"+iccid;
//            }
//        } else {
//            model.addAttribute("msg", "There is an operation currently running associated with this IPP");
//        }

        return "euicc_commands";
    }

    private String findProfileEnabledInOtherCard(String iccid) {
//    	List<Card> cards = cardao.searchByIccid(iccid);
//    	for (Card card : cards) {
//    		if (card.getProfileByIccid(iccid).getState().equals(CardProfile.PROFILE_STATE_ENABLED))
//    			return Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid());
//    	}
//		return null;
//	}
//    
//    private String findProfileInAnotherCard(String iccid) {
//    	List<Card> cards = cardao.searchByIccid(iccid);
//    	if (cards.isEmpty())
//    		return null;
//    	return Utils.toUnformattedHexArray(cards.get(0).getEumSignedInfo().getEid());
//    }
//
//	@GetMapping("home/euicc/commands/{eid}/generate-download")
//    public String generateDownload(Model model, @PathVariable String eid) {
//        return "euicc_generate_download";
//    }
//
//    @GetMapping("home/euicc/commands/{eid}/download-ipp")
//    public String downloadIpp(Model model, @PathVariable String eid) {
//        List<PresetCommand> presetCommands = presetdao.retrieveByAvailable(true);
//        List<PresetCommand> presetCommands1 = new ArrayList<>();
//        model.addAttribute("eid", eid);
//        Card card = cardao.retrieveByEid(eid);
//        SimpleProfileCard profProvisioning= new SimpleProfileCard(card.getProfiles().get(0));
//        
//        //parche instancias A y B juntas
//    	for(PresetCommand command : presetCommands){
//    		if (command.getInstanceCard()==null ||  card.getEumSignedInfo().getPlatformType()==null){
//    			presetCommands1.add(command);
//    		}
//    		else if(command.getInstanceCard().equals("B") && !card.getEumSignedInfo().getPlatformType().equals("CI_VALID_A"))
//    			presetCommands1.add(command);
//    		else if (command.getInstanceCard().equals("A") && card.getEumSignedInfo().getPlatformType().equals("CI_VALID_A"))
//    			presetCommands1.add(command);
//    	}
//    	
//        model.addAttribute("iccid", profProvisioning.getIccid());
//        model.addAttribute("presetcommands", presetCommands1);
//        String cardWithProfileEnabled;
//        HashMap<String, String> presetCommandsEnabled = new HashMap<>();
//        for (PresetCommand pc : presetCommands1) {
//        	if ( (cardWithProfileEnabled = findProfileEnabledInOtherCard(pc.getIccid())) != null) {
//        		presetCommandsEnabled.put(pc.getIccid(), cardWithProfileEnabled);
//        	}
//        }
//        
//        logger.logger("INFO", "SM-WEB", "eUICC", "", "Edit eUICC", "downloadIpp()", Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid()), "", 
//        		"EID eUICC: " + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid()), 
//        		"Shows a screen where add profiles to the eUICC");
//        
//        model.addAttribute("presetCommandsEnabled", presetCommandsEnabled);
        return "euicc_download_ipp";
    }

    @PostMapping("home/euicc/commands/{eid}/download-ipp")
    public String executeDownloadIpp(Model model, 
    		@PathVariable String eid, 
    		@RequestParam("action") String action, 
    		@RequestParam("iccid") String iccid) {

//        List<PresetCommand> presetCommands = presetdao.retrieveByAvailable(true);
//        model.addAttribute("presetcommands", presetCommands);
//
//        model.addAttribute("eid", eid);
//        Card card = cardao.retrieveByEid(eid);
//        String cardWithProfile;
//        SimpleProfileCard profProvisioning= new SimpleProfileCard(card.getProfiles().get(0));
//        model.addAttribute("iccid", profProvisioning.getIccid());
//        
//        if (!CampaignHelper.isAnyOperationRunning(eid)) {
//
//            if (action.compareTo("download") == 0) {
//            	if ( (cardWithProfile = findProfileInAnotherCard(iccid)) != null) {
//            		model.addAttribute("msg", "Cannot download it. Profile is already in card: " + cardWithProfile);
//            		dormir();
//            		
//            		logger.logger("ERROR", "SM-WEB", "eUICC", "", "Edit eUICC", "executeDownloadIpp()", Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid()), iccid, 
//            				"EID eUICC: " + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid()) + ", ICCID Profile: " + iccid, 
//            				"Impossible download the profile to the eUICC, this profile is already in other card (" + cardWithProfile + ")");
//            		
//            		return "euicc_download_ipp";
//            	} else {
//	                // Web service call
//            		presetdao.updateAvailable(iccid, false);
//	                ES2Helper.downloadProfile(eid, iccid, card.getSmsrId(), false);
//	                model.addAttribute("msg", "IPP is being downloaded");
//	                dormir();
//	                
//	                logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Edit eUICC", "executeDownloadIpp()", Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid()), iccid, 
//            				"EID eUICC: " + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid()) + ", ICCID Profile: " + iccid, 
//            				"Successfully downloaded the profile to the eUICC");
//	                
//	                return "redirect:/home/euicc/commands/" + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid());
//            	}
//            } else {
//            	if ( (cardWithProfile = findProfileInAnotherCard(iccid)) != null) {
//            		model.addAttribute("msg", "Cannot download & enable it. Profile is already in card: " + cardWithProfile);
//            		dormir();
//            		
//            		logger.logger("ERROR", "SM-WEB", "eUICC", "", "Edit eUICC", "executeDownloadIpp()", Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid()), iccid, 
//            				"EID eUICC: " + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid()) + ", ICCID Profile: " + iccid, 
//            				"Impossible download and enable the profile to the eUICC, this profile is already in other card (" + cardWithProfile + ")");
//            		
//            		return "euicc_download_ipp";
//            	} else {
//            		// Web service call
//            		ES2Helper.downloadProfile(eid, iccid, card.getSmsrId(), true);
//            		dormir();
//            		model.addAttribute("msg", "IPP is being downloaded and will be enabled");
//            		
//            		logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Edit eUICC", "executeDownloadIpp()", Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid()), iccid, 
//            				"EID eUICC: " + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid()) + ", ICCID Profile: " + iccid, 
//            				"Successfully downloaded and enable the profile to the eUICC");
//            		
//            		return "redirect:/home/euicc/commands/" + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid());
//            	}
//            }
//
//        } else {
//            model.addAttribute("msg", "There is an operation currently running associated with this IPP");
//            
//            logger.logger("WARNING", "SM-WEB", "eUICC", "", "Edit eUICC", "executeDownloadIpp()", Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid()), iccid, 
//            		"EID eUICC: " + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid()) + ", ICCID Profile: " + iccid, 
//            		"There is an operation currently running associated with this IPP");
//            
            dormir();
            return "euicc_download_ipp";
//       }

    }

    @PostMapping("home/euicc/ipp/results/download")
    public String executeDownload(Model model, @RequestParam("eid") String eid, @RequestParam("action") String action, @RequestParam("iccid") String iccid) {
//        List<PresetCommand> presetCommands = presetdao.retrieveByAvailable(true);
//        model.addAttribute("presetcommands", presetCommands);
//
//        model.addAttribute("eid", eid);
//        Card card = cardao.retrieveByEid(eid);
//        String cardWithProfile;
//        SimpleProfileCard profProvisioning= new SimpleProfileCard(card.getProfiles().get(0));
//        model.addAttribute("iccid", profProvisioning.getIccid());
//
//        if (!CampaignHelper.isAnyOperationRunning(eid)) {
//
//            if (action.compareTo("download") == 0) {
//                if ( (cardWithProfile = findProfileInAnotherCard(iccid)) != null) {
//                    model.addAttribute("msg", "Cannot download it. Profile is already in card: " + cardWithProfile);
//                    return "euicc_download_ipp";
//                } else {
//                    // Web service call
//                    ES2Helper.downloadProfile(eid, iccid, card.getSmsrId(), false);
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    //model.addAttribute("msg", "IPP is being downloaded");
//                    return "redirect:/home/euicc/commands/" + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid());
//                }
//            } else {
//                if ( (cardWithProfile = findProfileInAnotherCard(iccid)) != null) {
//                    model.addAttribute("msg", "Cannot download & enable it. Profile is already in card: " + cardWithProfile);
//                    return "euicc_download_ipp";
//                } else {
//                    // Web service call
//                    ES2Helper.downloadProfile(eid, iccid, card.getSmsrId(), true);
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    //model.addAttribute("msg", "IPP is being downloaded and will be enabled");
//                    return "redirect:/home/euicc/commands/" + Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid());
//                }
//            }
//
//        } else {
            model.addAttribute("msg", "There is an operation currently running associated with this IPP");
            return "euicc_download_ipp";
  //      }

    }

    @GetMapping("home/euicc/commands/{eid}/{available}")
    public String executeDisableFalback(Model model, @PathVariable("eid") String eid, 
    		@PathVariable("available") Boolean available) {
    	// Web service call
		ES3Helper.enableFallback(eid, available);
		
		logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Edit eUICC", "executeDisableFalback()", eid, "", 
				"EID eUICC: " + eid + ", Available: " + available, 
				"Disable Falback of the eUICC");
		
		return "redirect:/home/euicc/commands/" + eid;
    }
    
    @GetMapping("home/euicc/commands/{eid}/number")
    public String numberStatusFallback(Model model,
    		@PathVariable String eid,
    		@RequestParam("quantity") String quantity) {
    	// Web service call
		ES3Helper.statusNumberFallback(eid, quantity);
		
		logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Edit eUICC", "numberStatusFallback()", eid, "",
				"EID eUICC: " + eid + ", Quantity: " + quantity,
				"Send number status fallback");
		
		return "redirect:/home/euicc/commands/" + eid;
    }

    @GetMapping("home/euicc/delete Ipp/{eid}/{iccid}")
    public String deleteIpp(Model model, @PathVariable String iccid, @PathVariable String eid) {
//    	Card card = cardao.retrieveByIccidAndEid(eid,iccid);
//        cardao.removeIpp(card,iccid);
        return "euiccDelete";
    }

    @GetMapping("home/euicc/commands/{eid}/status")
    @ResponseBody
    public String getRunningOperations(Model model, @PathVariable String eid) {
    	
//    	com.movasim.sr.model.Card card = cardao.retrieveByEid(eid);
//        List<String> profilesWithOperationRunning = new ArrayList<>();
//        List<String> profilesWithOutOperationRunning = new ArrayList<>();
        JSONObject json = new JSONObject();
//        
//        for (com.movasim.sr.model.CardProfile profile : card.getProfiles()) {
//        	com.movasim.sr.model.Campaign campaign = campaigndao.retrieveOpenByIccid(profile.getIccid());
//        	if (campaign != null)
//        		profilesWithOperationRunning.add(profile.getIccid());
//        	else
//        		profilesWithOutOperationRunning.add(profile.getIccid());
//        }
//        Campaign campaignDescription=campaigndao.retrieveLastByEid(eid);
//        if(campaignDescription!=null){
//        	if(campaignDescription.getDescription()!=null)
//        		json.put("description",campaignDescription.getDescription());
//        	else
//        		json.put("description","Empty Description");
//
//        }
//        json.put("status", profilesWithOperationRunning.size() == 0);
//        json.put("running", profilesWithOperationRunning);
//        json.put("finshed", profilesWithOutOperationRunning);
//        List<Campaign> campainUpdatings=campaigndao.retrieveUpdating(eid);
//        if(campainUpdatings!=null){
//        	for(Campaign camp: campainUpdatings){
//        		camp.setStatus(Campaign.CAMPAIGN_STATUS_FINISHED);
//        		campaigndao.update(camp);
//        		profilesWithOutOperationRunning=new ArrayList<>();
//        		profilesWithOutOperationRunning.add(camp.getProfile().getIccid());
//        	}
//        	json.put("status", true);
//        	profilesWithOperationRunning=new ArrayList<>();
//            json.put("running", profilesWithOperationRunning);
//            json.put("finshed", profilesWithOutOperationRunning);
//        }
        return json.toString();

    }
    
    @GetMapping("home/euicc/commands/{eid}/refresh")
    @ResponseBody
    public String getRefreshView(Model model, @PathVariable String eid) {

    	List<String> profilesWithOperationRunning = new ArrayList<>();
    	JSONObject json = new JSONObject();
//    	com.movasim.sr.model.Campaign campaignRuning = campaigndao.retrieveRunningFallBack(eid);
//    	com.movasim.sr.model.Campaign campaignCreated = campaigndao.retrieveOpenFallBack(eid);
//    	if (campaignCreated != null)
//    		profilesWithOperationRunning.add(campaignCreated.getId());
//    	if (campaignRuning != null){
//    		//Update Campaign
//    		campaignRuning.setStatus(Campaign.CAMPAIGN_STATUS_FINISHED);
//    		campaigndao.update(campaignRuning);
//    		
//    		logger.logger("INFO", "SM-WEB", "eUICC", "", "", "getRefreshView()", eid, "", "EID: " + eid, "Restart true");
//    		
//    		if(campaignRuning.getDescription()!=null)
//        		json.put("description",campaignRuning.getDescription());
//        	else
//        		json.put("description","Empty Description");
//    		
//    		json.put("restart", true);
//    	}
//    	else{
//    		logger.logger("INFO", "SM-WEB", "eUICC", "", "", "getRefreshView()", eid, "", "EID: " + eid, "Restart false");
//    		
//    		json.put("restart", false);
//    	}
//
//    	logger.logger("INFO", "SM-WEB", "eUICC", "", "", "getRefreshView()", eid, "", "EID: " + eid, "Status: "+(profilesWithOperationRunning.size() == 0));
//    	
//    	json.put("status", profilesWithOperationRunning.size() == 0);
    	return json.toString();

    }
    
    @GetMapping("home/euicc/commands/{eid}/fallback")
    @ResponseBody
    public String getFallback(Model model, @PathVariable String eid) {
//    	com.movasim.sr.model.Card card = cardao.retrieveByEid(eid);
        JSONObject json = new JSONObject();
//        json.put("fallback", card.getFallbackEnabled());
        return json.toString();

    }

    @GetMapping("home/euicc/update/pol2/{eid}")
    public String getUpdatePOL2(Model model, @PathVariable String eid, 
    		@RequestParam(name="iccid") String iccid) {
    	model.addAttribute("eid",eid);
    	model.addAttribute("iccid", iccid);
    	
    	logger.logger("INFO", "SM-WEB", "eUICC", "", "Edit eUICC", "getUpdatePOL2()", eid, iccid, 
    			"EID eUICC: " + eid + ", ICCID Profile: " + iccid, 
    			"Opens a screen where you can change data the POL2");
    	
    	return "euicc_pol2";
    }

    @PostMapping("home/euicc/update/pol2/{eid}/{iccid}")
    public String postUpdatePOL2(Model model, 
    		@RequestParam(name="action", required=false) String action,
    		@PathVariable("iccid") String iccid, 
    		@PathVariable("eid") String eid,
    		@RequestParam(name="actionpol") String actionpol,
    		@RequestParam(name="qualification", required=false) String qualification,
    		@RequestParam(name="actionpol1", required=false) String actionpol1,
    		@RequestParam(name="qualification1", required=false) String qualification1) {
//    	if(action.compareTo("save") == 0) {
//    		 List<POL2RuleType> rules = new ArrayList<POL2RuleType>();
//    		if(!actionpol.equals("none")){
//    			POL2RuleType rule= new POL2RuleType();
//    			if(actionpol.equals("DISABLE"))
//    				rule.setAction(POL2RuleActionType.DISABLE);
//    			else
//    				rule.setAction(POL2RuleActionType.DELETE);
//    			if(qualification.equals("Auto-Delete"))
//    				rule.setQualification(POL2RuleQualificationType.AUTO_DELETE);
//    			else
//    				rule.setQualification(POL2RuleQualificationType.NOT_ALLOWED);    			
//    			rule.setSubject(POL2RuleSubjectType.PROFILE);
//    			rules.add(rule);
//    		}
//    		if(!actionpol1.equals("none")){
//    			POL2RuleType rule1= new POL2RuleType();
//    			if(actionpol1.equals("DISABLE"))
//    				rule1.setAction(POL2RuleActionType.DISABLE);
//    			else
//    				rule1.setAction(POL2RuleActionType.DELETE);
//    			if(qualification1.equals("Auto-Delete"))
//    				rule1.setQualification(POL2RuleQualificationType.AUTO_DELETE);
//    			else
//    				rule1.setQualification(POL2RuleQualificationType.NOT_ALLOWED);    			
//    			rule1.setSubject(POL2RuleSubjectType.PROFILE);
//    			rules.add(rule1);
//    		}
//    		Card card= cardao.retrieveByEid(eid);
//    		String smSrId=card.getSmsrId();
//    		ES2Helper.updatePol2(eid, smSrId, iccid, rules);
//    		model.addAttribute("msg", "Full POL2 update on the card: "+ eid);
//    		
//    		logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Edit eUICC", "postUpdatePOL2()", eid, iccid, 
//        			"Action POL2 (1): " + actionpol + ", Qualification (1): " + qualification 
//        				+ ", Action POL2 (2): " + actionpol1 + ", Qualification (2): " + qualification1, 
//        			"Update POL2 successfully");
//    	}
    	
    	return "redirect:/home/euicc/commands/" + eid;
    }
    
    @GetMapping("home/euicc/commands/srchange")
    public String ViewSMSRChange(Model model){
//    	List<Card> cards=cardao.retrieve();
//    	List<String> eids=new ArrayList<>();
//    	for(Card card: cards){
//    		eids.add(com.movasim.sr.utils.Utils.toUnformattedHexArray(card.getEumSignedInfo().getEid()));
//    	}
//    	List<SR> srs= srdao.retrieveAll();
//    	model.addAttribute("srFound",srs);
//    	model.addAttribute("cardsEids", eids);
//    	
//    	logger.logger("INFO", "SM-WEB", "eUICC", "", "SM-SR Change", "viewSMSRChange()", "", "", "", "Opens a screen where can doing a SM-SR change");
//    	
    	return "euicc_smsrchange";
    }
    
    @PostMapping("home/euicc/commands/srchange")
    public String smSrChange(Model model, 
    		@RequestParam("eid") String eid,
    		@RequestParam("origin") String origin ,
    		@RequestParam("destiny") String destiny) {
    	
    	// Web service call
    	ES4Helper.smSrChange(eid, origin, destiny);
    	model.addAttribute("msg", "SmSrChange");
    	dormir();
    	
    	logger.logger("DEBUG", "SM-WEB", "eUICC", "", "SM-SR Change", "smSrChange()", eid, "", "EID eUICC: " + eid + "Origin: " + ", Destiny: " + destiny, "Successfully SM-SR change");
    	
    	return "redirect:/home/euicc/search/";
    }
    
    @PostMapping("home/euicc/commands/preparesrchange")
    public String prepareSmSrChange(Model model, 
    		@RequestParam("eid") String eid,
    		@RequestParam("origin") String origin ,
    		@RequestParam("destiny") String destiny) {
    	
    	// Web service call
    	ES4Helper.prepareSmSrChange(eid,origin,destiny);
    	model.addAttribute("msg", "PrepareSmSrChange");
    	dormir();
    	
    	logger.logger("DEBUG", "SM-WEB", "eUICC", "", "SM-SR Change", "prepareSmSrChange()", eid, "", "EID eUICC: " + eid + "Origin: " + ", Destiny: " + destiny, "Successfully SM-SR prepare");
    	
    	return "redirect:/home/euicc/search/";
    }
    
    
    							/*					CARD LOTS					*/
    
    @GetMapping("home/euicc/{action}/lots")
    public String allEuiccActionCardLots(Model model,
    		@PathVariable String action) {
    	
    	if(action.equals("add")) {
//    		
//    		List<com.movasim.sr.model.Card> cards = null;
//        	
//        	cards = cardao.retrieve();
//        
//    	    List<SimpleCard> simpleCards = new ArrayList<SimpleCard>();
//    	    for (int i = 0; i < cards.size(); i++) {
//    	        simpleCards.add(new SimpleCard(cards.get(i)));
//    	    }
//    		
//    	    model.addAttribute("cardsFound", simpleCards);
//    	    model.addAttribute("nameAction", "Add");
//    	    model.addAttribute("action", "add");
//    	    
//    	    logger.logger("INFO", "SM-WEB", "eUICC", "", "Show eUICC", "allEuiccActionCardLots()", "", "", "", "Shows all eUICC for add card lots");
//        	
        	return "euicc_all_action_lots";
    	}
    	
    	if(action.equals("delete")) {
    		
//    		List<com.movasim.sr.model.Card> cards = null;
//        	
//        	cards = cardao.retrieve();
//        
//    	    List<SimpleCard> simpleCards = new ArrayList<SimpleCard>();
//    	    for (int i = 0; i < cards.size(); i++) {
//    	        simpleCards.add(new SimpleCard(cards.get(i)));
//    	    }
//    		
//    		model.addAttribute("cardsFound", simpleCards);
//    	    model.addAttribute("nameAction", "Delete");
//    	    model.addAttribute("action", "delete");
//        	
//    	    logger.logger("INFO", "SM-WEB", "eUICC", "", "Show eUICC", "allEuiccActionCardLots()", "", "", "", "Shows all eUICC for delete their card lots");
    	    
        	return "euicc_all_action_lots";
    	}
    	
    	if(action.equals("view")) {
//    		
//    		List<com.movasim.sr.model.Card> cards = null;
//        	
//        	cards = cardao.retrieve();
//        
//    	    List<SimpleCard> simpleCards = new ArrayList<SimpleCard>();
//    	    for (int i = 0; i < cards.size(); i++) {
//    	        simpleCards.add(new SimpleCard(cards.get(i)));
//    	    }
//    		
//    		model.addAttribute("cardsFound", simpleCards);
//    	    model.addAttribute("nameAction", "View");
//    	    model.addAttribute("action", "view");
//    	    
//    	    logger.logger("INFO", "SM-WEB", "eUICC", "", "Show eUICC", "allEuiccActionCardLots()", "", "", "", "Shows all eUICC for view their card lots");
//        	
        	return "euicc_all_action_lots";
    	}
    	
    	return "euicc_search";
    }
    
    @GetMapping("home/euicc/{action}/lots/card/{eid}")
    public String euiccActionCardLots(Model model, 
    		@PathVariable String eid,
    		@PathVariable String action) {
    	
//    	if(action.equals("add")) {
//    		
//    		com.movasim.sr.model.Card card = new com.movasim.sr.model.Card();
//        	card = cardao.retrieveByEid(eid);
//        	SimpleCard simpleCard = new SimpleCard(card);
//        	
//        	List<LotCard> cardLots = addLotes();
//        	
//            model.addAttribute("cardLotsFound", cardLots);
//        	model.addAttribute("cardToEdit", simpleCard);
//        	model.addAttribute("action", "add");
//        	
//        	logger.logger("INFO", "SM-WEB", "eUICC", "", "Add card lot", "euiccActionCardLots()", eid, "", 
//        			"EID eUICC: " + eid, 
//        			"A screen opens where shows all lots for add to a specific eUICC");
//        	
//        	return "euicc_action_card_lots";
//    	}
//    	
//    	if(action.equals("delete")) {
//    		
//    		com.movasim.sr.model.Card card = new com.movasim.sr.model.Card();
//        	card = cardao.retrieveByEid(eid);
//        	SimpleCard simpleCard = new SimpleCard(card);
//        	
//        	List<LotCard> cardLots = addLotes();
//        	
//            model.addAttribute("cardLotsFound", cardLots);
//        	model.addAttribute("cardToEdit", simpleCard);
//        	model.addAttribute("action", "delete");
//        	
//        	logger.logger("INFO", "SM-WEB", "eUICC", "", "Delete card lot", "euiccActionCardLots()", eid, "", 
//        			"EID eUICC: " + eid, 
//        			"A screen opens where shows all lots for delete to a specific eUICC");
//        	
//        	return "euicc_action_card_lots";
//    	}
//    	
    	return "euicc_search";
    }
    
    @PostMapping("home/euicc/add/lots/card/{eid}")
    public String euiccAddCardLots(Model model, HttpServletRequest request,
    		@PathVariable String eid,
    		@RequestParam (name = "action") String action) {
//    	com.movasim.sr.model.Card card = cardao.retrieveByEid(eid);
//    	
//    	List<LotCard> listLots = lotcarddao.retrieveAll();
//    	
//    	List<String> listOfMsgEdit = new ArrayList<>();
//    	List<String> listOfMsgView = new ArrayList<>();
//    	
//    	List<String> listOfMsgEditRepeated = new ArrayList<>();
//    	List<String> listOfMsgViewRepeated = new ArrayList<>();
//    	
//    	if(action.compareTo("save") == 0) {
//    	
//    		for (LotCard lotCard : listLots) {    		
//
//        		if(request.getParameter("edit_" + lotCard.getNameLot()).equals("true")) {
//        			
//        			Boolean repeated = false;
//        			Boolean repeatedInView = false;
//        			
//        			for (int i = 0; i < card.getListLotsEdit().size(); i++) {
//        				if (card.getListLotsEdit().get(i).equals(lotCard.getNameLot())) {
//        					repeated = true;
//        					listOfMsgEditRepeated.add("The card lot " + lotCard.getNameLot() + " for edit already this has the card with EID: " + eid);
//        					
//        					logger.logger("WARNING", "SM-WEB", "eUICC", "", "Add card lot", "euiccAddCardLots()", eid, "", 
//        							"EID eUICC: " + eid + ", Card lot name: " + lotCard.getNameLot(), 
//        							"This eUICC has the card lot what are you trying to add");
//        					
//        					break;
//        				}	
//        			}
//        			
//        			for (int i = 0; i < card.getListLotsView().size(); i++) {
//        				if(card.getListLotsView().get(i).equals(lotCard.getNameLot())) {
//        					repeatedInView = true;
//        					break;
//        				}
//        			}
//        			
//        			if(!repeated) {
//        				card.getListLotsEdit().add(lotCard.getNameLot());
//        				
//        				if(!repeatedInView) {
//        					card.getListLotsView().add(lotCard.getNameLot());
//        				}
//        				
//            			cardao.update(card);
//            			
//            			logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Add card lot", "euiccAddCardLots()", eid, "", 
//            					"EID eUICC: " + eid + ", Card lot name: " + lotCard.getNameLot(), 
//            					"Successfully added the card lot for edit to eUICC");
//            			
//            			listOfMsgEdit.add("Add card lot " + lotCard.getNameLot() + " for edit to the card with EID: " + eid);
//        			}
//        		}
//        		
//        		if(request.getParameter("view_" + lotCard.getNameLot()).equals("true")) {
//        			
//        			Boolean repeated = false;
//        			
//        			for (int i = 0; i < card.getListLotsView().size(); i++) {
//            			
//            			if (card.getListLotsView().get(i).equals(lotCard.getNameLot())) {
//            				repeated = true;
//            				listOfMsgViewRepeated.add("The card lot " + lotCard.getNameLot() + " for view already this has the card with EID: " + eid);
//            				
//            				logger.logger("WARNING", "SM-WEB", "eUICC", "", "Add card lot", "euiccAddCardLots()", eid, "", 
//        							"EID eUICC: " + eid + ", Card lot name: " + lotCard.getNameLot(), 
//        							"This eUICC has the card lot what are you trying to add");
//            			}
//            		}
//        			
//        			if(!repeated) {
//            			card.getListLotsView().add(lotCard.getNameLot());
//            			cardao.update(card);
//            			
//            			logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Add card lot", "euiccAddCardLots()", eid, "", 
//            					"EID eUICC: " + eid + ", Card lot name: " + lotCard.getNameLot(), 
//            					"Successfully added the card lot for view to eUICC");
//            			
//            			listOfMsgView.add("Add card lot " + lotCard.getNameLot() + " for view to the card with EID: " + eid);
//        			}
//        		}
//        	}
//        	
//        	model.addAttribute("msgEdit", listOfMsgEdit);
//        	model.addAttribute("msgView", listOfMsgView);
//        	
//			model.addAttribute("msgEditRepeated", listOfMsgEditRepeated);
//			model.addAttribute("msgViewRepeated", listOfMsgViewRepeated);
//			
//        	addDpName(model);
//        	return "euicc_search";
//    	}
    	
    	return "redirect:/home/euicc/add/lots";
    }
       
    @PostMapping("home/euicc/delete/lots/card/{eid}")
    public String euiccDeleteCardLots(Model model, HttpServletRequest request,
    		@PathVariable String eid,
    		@RequestParam(name = "action") String action) {
//    	
//    	if(action.compareTo("save") == 0) {
//    		
//    		com.movasim.sr.model.Card card = cardao.retrieveByEid(eid);
//        	
//        	List<String> deleteLotsEdit = new ArrayList<>();
//        	List<String> deleteLotsView = new ArrayList<>();
//        	
//        	List<String> neverDeleteEdit = new ArrayList<>();
//        	List<String> neverDeleteView = new ArrayList<>();
//    		
//    		List<LotCard> listLots = lotcarddao.retrieveAll();
//    		
//    		for (LotCard lotCard : listLots) {
//
//        		if(request.getParameter("edit_" + lotCard.getNameLot()).equals("true")) {
//        			
//        			Boolean delete = false;
//        			
//        			for(int i = 0; i < card.getListLotsEdit().size(); i++) {
//        				if (card.getListLotsEdit().get(i).equals(lotCard.getNameLot())) {
//        					card.getListLotsEdit().remove(i);
//        					
//        					logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Delete card lot", "euiccDeleteCardLots()", eid, "", 
//        							"EID eUICC: " + eid + ", Card lot name: " + lotCard.getNameLot(), 
//        							"Successfully deleted the card lot for edit in the eUICC");
//        					
//        					deleteLotsEdit.add("Delete card lot " + lotCard.getNameLot() + " for edit in the card with EID " + eid);
//        					delete = true;
//        					break;
//        				}
//        			}
//        			
//        			for (int i = 0; i < card.getListLotsView().size(); i++) {
//        				if (card.getListLotsView().get(i).equals(lotCard.getNameLot()) && delete) {
//        					card.getListLotsView().remove(i);
//        					
//        					logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Delete card lot", "euiccDeleteCardLots()", eid, "", 
//        							"EID eUICC: " + eid + ", Card lot name: " + lotCard.getNameLot(), 
//        							"Successfully deleted the card lot for view in the eUICC");
//        					
//        					deleteLotsEdit.add("Delete card lot " + lotCard.getNameLot() + " for view in the card with EID " + eid);
//        					break;
//        				}
//        			}
//        			
//        			if(delete) {
//        				cardao.update(card);
//        			} else {
//        				neverDeleteEdit.add("Impossible delete card lot " + lotCard.getNameLot() + " for edit, the card with EID " + eid + " dont have this lot");
//        				
//        				logger.logger("WARNING", "SM-WEB", "eUICC", "", "Delete card lot", "euiccDeleteCardLots()", eid, "", 
//        						"EID eUICC: " + eid + ", Card lot name: " + lotCard.getNameLot(),
//        						"Could not delete the card lot for edit because the eUICC hasn't this lot");
//        			}
//        		}
//        		
//        		
//        		
//        		if(request.getParameter("view_" + lotCard.getNameLot()).equals("true")) {
//        			
//        			Boolean inEdit = false;
//        			Boolean delete = false;
//        			
//        			for (int i = 0; i < card.getListLotsEdit().size(); i++) {
//        				if(card.getListLotsEdit().get(i).equals(lotCard.getNameLot())) {
//        					neverDeleteView.add("Impossible delete card lot " + lotCard.getNameLot() + " for view, the card with EID " + eid + " have this lot for edit");
//        					
//        					logger.logger("WARNING", "SM-WEB", "eUICC", "", "Delete card lot", "euiccDeleteCardLots()", eid, "", 
//        							"EID eUICC: " + eid + ", Card lot name: " + lotCard.getNameLot(), 
//        							"Could not delete the lot for view because the eUICC has this lot for edit");
//        					
//        					inEdit = true;
//        					break;
//        				}
//        			}
//        			
//        			if(!inEdit) {
//        				
//        				for (int i = 0; i < card.getListLotsView().size(); i++) {
//            				if(card.getListLotsView().get(i).equals(lotCard.getNameLot())) {
//            					card.getListLotsView().remove(i);
//            					
//            					logger.logger("DEBUG", "SM-WEB", "eUICC", "", "Delete card lot", "euiccDeleteCardLots()", eid, "", 
//            							"EID eUICC: " + eid + ", Card lot name: " + lotCard.getNameLot(), 
//            							"Successfully deleted the card lot for view in the eUICC");
//            					
//            					deleteLotsView.add("Delete card lot " + lotCard.getNameLot() + " for view in the card with EID " + eid);
//            					delete = true;
//            					break;
//            				}
//            			}
//            			
//            			if(delete) {
//            				cardao.update(card);
//            			} else {
//            				neverDeleteView.add("Impossible delete card lot " + lotCard.getNameLot() + " for view, the card with EID " + eid + " dont have this lot");
//            				
//            				logger.logger("WARNING", "SM-WEB", "eUICC", "", "Delete card lot", "euiccDeleteCardLots()", eid, "", 
//            						"EID eUICC: " + eid + ", Card lot name: " + lotCard.getNameLot(),
//            						"Could not delete the card lot for view because the eUICC hasn't this lot");
//            			}
//        			}
//        		}
//    		}
//    		
//    		model.addAttribute("deleteLotsEdit", deleteLotsEdit);
//    		model.addAttribute("deleteLotsView", deleteLotsView);
//    		
//    		model.addAttribute("neverDeleteEdit", neverDeleteEdit);
//    		model.addAttribute("neverDeleteView", neverDeleteView);
//    		
//    		addDpName(model);
//        	return "euicc_search";
//    	}
    	
    	return "redirect:/home/euicc/delete/lots";
    }
    
    
    @GetMapping("home/euicc/view/lots/card/{eid}")
    public String euiccViewCardLots(Model model,
    		@PathVariable String eid) {
//    	com.movasim.sr.model.Card card = cardao.retrieveByEid(eid);
//    	
//    	List<String> listOfViewLots = card.getListLotsView();
//    	List<String> listOfEditLots = card.getListLotsEdit();
//    	SimpleCard simpleCard = new SimpleCard(card);
//    	
//    	if(listOfViewLots.isEmpty()) {
//    		listOfViewLots.add("Empty");
//    	}
//    	
//    	if(listOfEditLots.isEmpty()) {
//    		listOfEditLots.add("Empty");
//    	}
//    	
//    	model.addAttribute("listOfViewLots", listOfViewLots);
//    	model.addAttribute("listOfEditLots", listOfEditLots);
//    	model.addAttribute("simpleCard", simpleCard);
//    	
//    	logger.logger("INFO", "SM-WEB", "eUICC", "", "View card lot", "euiccActionCardLots()", eid, "", 
//    			"EID eUICC: " + eid, 
//    			"A screen opens where shows all card lots of a specific eUICC");
//    	
    	return "euicc_view_lots_card";
    }
    
    						/*						UTILS					*/
    
    @SuppressWarnings("unused")
	private static class MyStreamReaderDelegate extends StreamReaderDelegate {
    	 
        public MyStreamReaderDelegate(XMLStreamReader xsr) {
            super(xsr);
        }
 
        @Override
        public String getAttributeLocalName(int index) {
            return super.getAttributeLocalName(index).toLowerCase();
        }
 
        @Override
        public String getLocalName() {
            return super.getLocalName().toLowerCase();
        }
 
    }
    
    private void addDpName(Model model){
//    	com.movasim.dp.DAO.KeysDAO dpdao= new com.movasim.dp.DAO.KeysDAO();
//    	List<com.movasim.dp.model.Keys> dps= (List<com.movasim.dp.model.Keys>)dpdao.retrieveAll();
//    	ArrayList<String> dpname= new ArrayList<>();
//    	for(com.movasim.dp.model.Keys dp :dps)
//    		dpname.add(dp.getName());
//	 	model.addAttribute("dp",dpname);
    }

    private static void dormir(){
    	try
        {
            Thread.sleep(4000);
        }catch(InterruptedException e){}
    }


    private void bleachingProfiles(String eid){
//    	Card card=cardao.retrieveByEid(eid);
//    	if (card!=null && !card.getProfiles().isEmpty()){
//    		for(CardProfile profile: card.getProfiles()){
//    			PresetCommand ipp=presetdao.retrieveByICCID(profile.getIccid());
//    			if(ipp!=null){
//    				ipp.setAvailable(true);
//    				ipp.setCardeid("");
//    				ipp.setMnoid("");
//    				presetdao.update(ipp);
//    			}
//    		}
//    	}
    }
    
    public List<LotCard> addLotes(){
        List<LotCard> listLotes = lotcarddao.retrieveAll();
        return listLotes;
    }
    
    /**
     * 
     * @param user: Usuario a verificar
     * @param listCards: Lista de todas las tarjetas
     * @param cardAddModel: Lista de tarjetas a mostrar en la web
     */
//	private void loadCardForLotView(User user, List<Card> listCards, List<SimpleCard> cardAddModel) {

//		for (Card card : listCards) {
//			
//			if(user.getRole().equals("SUPERADMIN") && card.getListLotsView().size() == 0) {
//				cardAddModel.add(new SimpleCard(card));
//			}
//			
//			for (int i = 0; i < card.getListLotsView().size(); i++) {
//				if (user.getListCardLots().getListLotsCardsView().contains(card.getListLotsView().get(i)) || user.getRole().equals("SUPERADMIN")) {
//					cardAddModel.add(new SimpleCard(card));
//					break;
//				}
//			}
//		}
//	}
	
	/**
	 * 
	 * @param card: eUICC a comprobar la lista
	 * @param user: usuario logeado
	 */
//	public Boolean editCardForLotEdit(Card card, User user) {
//		for (int i = 0; i < card.getListLotsEdit().size(); i++) {
//			if(user.getListCardLots().getListLotsCardsEdit().contains(card.getListLotsEdit().get(i))) {
//				return true;
//			}
//        }
//		
//		if(user.getRole().equals("SUPERADMIN") && card.getListLotsEdit().size() == 0) {
//			return true;
//		}
//		
//		return false; 
//	}
}
