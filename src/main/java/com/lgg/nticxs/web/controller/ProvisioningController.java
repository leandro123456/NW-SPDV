package com.lgg.nticxs.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.lgg.nticxs.utils.Settings;
import com.lgg.nticxs.utils.WSLogger;
import com.lgg.nticxs.web.DAO.DocumentoDAO;
import com.lgg.nticxs.web.helper.ES1Helper;
import com.lgg.nticxs.web.helper.SRHelper;
import com.lgg.nticxs.web.model.Documento;
import com.lgg.nticxs.web.model.SimpleClasificationIPP;


@Controller
public class ProvisioningController {
	 SRHelper srHelper= new SRHelper();
	 DocumentoDAO docdao = new DocumentoDAO();
	 
	 private static WSLogger logger = new WSLogger();
	 
    @GetMapping("home/provisioning")
    public String  doProfileTemplateUpload(Model model){      
        return "provisioning";
    }

    @PostMapping("home/provisioning/documento")
    public String doProfileTemplateUpload(Model model, 
    		@RequestParam("documento") MultipartFile documento, 
    		@RequestParam("nombre") String nombre, 
    		@RequestParam("descripcion") String descripcion) {
    	String fileName = null;

        if (!documento.isEmpty()) {
            try {
            	Documento document = new Documento();
                fileName = documento.getOriginalFilename();
                byte[] bytes = documento.getBytes();
                document.setAvailable(true);
                document.setDescripcion(descripcion);
                document.setFecha(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")));
                document.setMateria("materia");
                document.setName(nombre);
                docdao.create(document);
//                TemplateIppDAO tempDAO = new TemplateIppDAO();
//                TemplateIpp temp= tempDAO.retrieveByName(template);
//                if(temp== null) {
//                    temp=new TemplateIpp();
//                    temp=SettingsValuesDefaultTemplate(category,clase,type,template, available,fileName);
//                    tempDAO.create(temp);
//                }else{
//                    temp=SettingsValuesDefaultTemplate(category,clase,type,template, available,fileName);
//                    tempDAO.update(temp);
//                }
                
                logger.logger("DEBUG", "SM-WEB", "Provisioning", "", "Upload Template", "doProfileTemplateUpload()", "", "", 
                		"Template name: " + template + "Category: " + ", " + category + ", " + "Class: " + clase + ", " + "Type: " +type + "."
                		, "Successfull upload");
                
                model.addAttribute("msg1", "You have successfully uploaded");
               // loadPageProvisioning(model);
                return "provisioning";
            } catch (Exception e) {
            	//loadPageProvisioning(model);
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                
                logger.logger("ERROR", "SM-WEB", "Provisioning", "", "Upload Template", "doProfileTemplateUpload()", "", "", 
                		"Template name: " + template + "Category: " + ", " + category + ", " + "Class: " + clase + ", " + "Type: " +type + "."
                		, "Failed to upload");
                
                model.addAttribute("msg1", "You failed to upload" + errors.toString());
                return "provisioning";
            }
        } else {
        	//loadPageProvisioning(model);
            model.addAttribute("msg1", "Unable to upload. File is empty.");
            
            logger.logger("WARNING", "SM-WEB", "Provisioning", "", "Upload Template", "doProfileTemplateUpload()", "", "", 
            		"Template name: " + template + "Category: " + ", " + category + ", " + "Class: " + clase + ", " + "Type: " +type + "."
            		, "Unable to upload. File is empty");
            
            return "provisioning";
        }
    }

    @PostMapping("home/provisioning/data")
    public String doProfileUpload(Model model, @RequestParam("file_template") MultipartFile file, @RequestParam("name") String name) {
        String fileName = null;

        if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(Settings.getInstance().getFILE_UPLOAD_PATH_PERSONALISATION_IPP() + fileName)));
                buffStream.write(bytes);
                buffStream.close();
         		String fileContent = new String(Files.readAllBytes(Paths.get(Settings.getInstance().getFILE_UPLOAD_PATH_PERSONALISATION_IPP() + fileName)));
                String[] headers = {};
        		String[] dataLines = {};
//        		PersonalisationIppDAO perDAO = new PersonalisationIppDAO();
        		Pattern pattern = Pattern.compile("var_out:(.+?)\n(.+?)$", Pattern.DOTALL);
        		Matcher matcher = pattern.matcher(fileContent);
        		
        		if (!matcher.find()) {
                    model.addAttribute("msg3", "Unable to upload. Failed to parse.");
                    
                    logger.logger("ERROR", "SM-WEB", "Provisioning", "", "Upload profile", "doProfileUpload()", "", "", "", "Unable to upload. Failed to parse.");
                    
                    return "provisioning";
        		}
        		
        		headers = matcher.group(1).split("/");
        		dataLines = matcher.group(2).split("\r\n");
        		String text=dataLines[0];
        		ArrayList<Integer> value=new ArrayList<>();
        		value.add(0);
        		
        		for(int i=0; i<text.length();i++){
        			if (text.charAt(i)=='\n')
        				value.add(i);
        		}
        		
        		dataLines=new String[value.size()-1];
        		
        		for(int j=0;j<value.size()-1;j++){
        			if (j==0)
        				dataLines[j]=text.substring(value.get(j), value.get(j+1));
        			else
        				dataLines[j]=text.substring(value.get(j)+1, value.get(j+1));
        		}
        		
        		/** hasta aca*/	
        		@SuppressWarnings("unused")
				Gson gson = new Gson();
        		for (String line : dataLines) {	
        			Map<String, String> map = new HashMap<String, String>();
        			String[] values = line.split(";");
        			
        			for (int i = 0; i < headers.length; i++) {
        				if(headers[i].equals("MSISDN")){
        					
        					logger.logger("INFO", "SM-WEB", "Provisioning", "", "Upload profile", "doProfileUpload()", "", "", "", "This is for MSISDN -->"+values[i]+"<--");
        				
        				}
        				map.put(headers[i], values[i]);				
        			}
        			
        			// Create personalization
//        			String iccidRotate=Utils.rotateIccid(map.get(Settings.getInstance().getIccidName()));
//        			String imsi = map.get(Settings.getInstance().getImsiName());
//        			PersonalisationIpp personalizationIppAux = perDAO.retrieveByIccid(iccidRotate);
//        			PersonalisationIpp personalizationIpp = new PersonalisationIpp();
//        			String aux= map.get(Settings.getInstance().getMsisdnName());

//        			logger.logger("INFO", "SM-WEB", "Provisioning", "", "Upload profile", "doProfileUpload()", "", "", "", "Value MSISDN " + aux);
//        			
//        			personalizationIpp.setMsisdn(aux);
//        			HashMap<String,String> valuesMsisdn= Utils.takeMsisdnCardProfile("ipp");
//        			
//        			//Process
//        			personalizationIpp.setIccid(iccidRotate);
//        			personalizationIpp.setImsi(imsi);
//        			if(valuesMsisdn!=null)
//        				personalizationIpp.setMsisdn(valuesMsisdn.get(iccidRotate));
//        			else if(map.get(Settings.getInstance().getMsisdnName())!=null)
//        				personalizationIpp.setMsisdn(map.get(Settings.getInstance().getMsisdnName()));
//        			personalizationIpp.setName(name);
//        			
        			//Decrypted 3 DES
        			String parameterToDecrypted=Settings.getInstance().getParameterToDecrypted();
           			String[] parameters = parameterToDecrypted.split("/");
        			
           			for (int i = 0; i < parameters.length; i++) {
        				try{
//        					map.replace(parameters[i], Utils.decrypt3Des(Settings.getInstance().getKeyMovasim(), map.get(parameters[i])));			
        				}catch(Exception e){
        					e.printStackTrace();
        				}
        			}
           			
//        			map.replace(Settings.getInstance().getMsisdnName(), personalizationIpp.getMsisdn());
//        			personalizationIpp.setPersonalisationInfo(new Gson().toJson(map));
//        			personalizationIpp.setDeleted(false);
//        			
//        			if (personalizationIppAux==null){
//        				perDAO.create(personalizationIpp);
//        			} else {
//        				personalizationIpp.setId(personalizationIppAux.getId());
//        				perDAO.update(personalizationIpp);
//        			}
        		}
        		
        		logger.logger("DEBUG", "SM-WEB", "Provisioning", "", "Upload profile", "doProfileUpload()", "", "", "", "Successfully uploaded");
        		
                model.addAttribute("msg3", "You have successfully uploaded ");
              //  loadPageProvisioning(model);
                return "provisioning";
            } catch (Exception e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                
                logger.logger("ERROR", "SM-WEB", "Provisioning", "", "Upload profile", "doProfileUpload()", "", "", "", "You failed to upload. " + errors.toString());
                
                model.addAttribute("msg3", "You failed to upload "+ errors.toString());
              //  loadPageProvisioning(model);
                return "provisioning";
            }
            
        } else {
            model.addAttribute("msg3", "Unable to upload. File is empty.");
            
            logger.logger("WARNING", "SM-WEB", "Provisioning", "", "Upload profile", "doProfileUpload()", "", "", "", "Unable to upload. File is empty.");
            
           // loadPageProvisioning(model);
            return "provisioning";
        }
    }

    @PostMapping("home/provisioning/all")
    public String doProfileTemplateUploadAll(Model model, 
    		@RequestParam("file_template") MultipartFile file, 
    		@RequestParam("template") String template,
    		@RequestParam("iccid") String iccid,
    		@RequestParam("imsi") String imsi,
    		@RequestParam("listMno") String listMno,
    		@RequestParam("msisdn") String msisdn, 
    		@RequestParam(name="active", required=false, defaultValue = "false") Boolean available) {
        String fileName = null;
//        PresetCommandDAO presetCommandDAO = new PresetCommandDAO();
        if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
//                byte[] bytes = file.getBytes();
//                BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(Settings.getInstance().getFILE_UPLOAD_PATH_IPP() + fileName)));
//                buffStream.write(bytes);
//                buffStream.close();
                
                // Update or create
//                PresetCommand presetCommand = presetCommandDAO.retrieveByICCID(iccid);

//                if (presetCommand == null) {
//                    presetCommand = new PresetCommand();
//                    presetCommand=SettingsValuesDefaultIPP(template, iccid,imsi, msisdn,listMno, fileName);
//                    presetCommandDAO.create(presetCommand);
//                } else {
//                	presetCommand=SettingsValuesDefaultIPP(template, iccid,imsi, msisdn,listMno, fileName);
//                    presetCommandDAO.update(presetCommand);
//                }
                
//                loadPageProvisioning(model);
                model.addAttribute("msg2", "You have successfully uploaded");
//                
//                logger.logger("DEBUG", "SM-WEB", "Provisioning", "", "Upload all profile", "doProfileTemplateUploadAll()", "", 
//                		iccid, template + ", " + imsi + ", " + listMno + ", " + msisdn, "Successfull upload");
//                
                return "provisioning";
            } catch (Exception e) {
            //	loadPageProvisioning(model);
            	StringWriter errors = new StringWriter();
            	e.printStackTrace(new PrintWriter(errors));
                model.addAttribute("msg2", "You failed to upload"+ errors.toString());
                
                logger.logger("ERROR", "SM-WEB", "Provisioning", "", "Upload all profile", "doProfileTemplateUploadAll()", "", iccid,
                		"Name template: " + template + ", " + "IMSI: " + imsi + ", " + "List MNO: " + listMno + ", " + "MSISDN: " + msisdn,
                		"Failed to upload. " + errors.toString());
                
                return "provisioning";
            }
        } else {
        	//loadPageProvisioning(model);
            model.addAttribute("msg2", "Unable to upload. File is empty.");
            
            logger.logger("WARNING", "SM-WEB", "Provisioning", "", "Upload all profile", "doProfileTemplateUploadAll()", "", iccid,
            		"Name template: " + template + ", " + "IMSI: " + imsi + ", " + "List MNO: " + listMno + ", " + "MSISDN: " + msisdn,
            		"Unable to upload, file is empty");
            
            return "provisioning";
        }
    }
    
    @PostMapping("home/provisioning/euicc")
    public String doEuiccInfoUpload(Model model, @RequestParam("file") MultipartFile file,
    		@RequestParam(name="dpname", required=false) String dpname,
    		@RequestParam(name="srname", required=false) String srname) {
        String fileName = null;
        
        if (!file.isEmpty()) {
        	try {
//    			JAXBContext context = JAXBContext.newInstance(EISType.class);
//    			Unmarshaller unmarshaller = context.createUnmarshaller();
    			
    			fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(Settings.getInstance().getFILE_UPLOAD_PATH_CARDS() +fileName)));
                buffStream.write(bytes);
                buffStream.close();
        		String dir = Settings.getInstance().getFILE_UPLOAD_PATH_CARDS()+fileName;
        		
        		@SuppressWarnings("resource")
				ZipFile zip = new ZipFile(dir);
    			Enumeration<? extends ZipEntry> entries = zip.entries();
//    			HashMap<String,String> valuesMsisdn= Utils.takeMsisdnCardProfile("card");
                
//    			while(entries.hasMoreElements()) {
//                	ZipEntry entry = entries.nextElement();
//                    com.movasim.sr.ws.generated.EISType eis = (com.movasim.sr.ws.generated.EISType) unmarshaller.unmarshal(zip.getInputStream(entry));
//                    for(com.movasim.sr.ws.generated.EISType.ProfileInfo profile : eis.getProfileInfo()){
//                    	String valueMsisdn= valuesMsisdn.get(profile.getIccid());
//                    	if(valueMsisdn!=null)
//                    		profile.getSubscriptionAddress().setMsisdn(valueMsisdn);
//                    }
//						loadSr(srname,eis);
//						loadDp(dpname,eis);
//                }
//    			
//                loadPageProvisioning(model);
//                model.addAttribute("msg4", "You have successfully uploaded");
//                
//                logger.logger("DEBUG", "SM-WEB", "Provisioning", "", "Upload eUICC", "doEuiccInfoUpload()", "", "", "DP name: " + dpname + ", " + "SR name: " + srname, "Successfull upload");
//                
//                return "provisioning";
//    		} catch (Exception e) {
//    			 StringWriter errors = new StringWriter();
//                 e.printStackTrace(new PrintWriter(errors));
//                 
//                 logger.logger("ERROR", "SM-WEB", "Provisioning", "", "Upload eUICC", "doEuiccInfoUpload()", "", "", "DP name: " + dpname + ", " + "SR name: " + srname, "Failed to upload. " + e);
//                 
//                 model.addAttribute("msg4", "You failed to upload "+ errors.toString());
//                 
//    			 e.printStackTrace();
//    			 loadPageProvisioning(model);
//                 return "provisioning";
//    		}
//        } else {
//        	loadPageProvisioning(model);
//        	
//        	logger.logger("WARNING", "SM-WEB", "Provisioning", "", "Upload eUICC", "doEuiccInfoUpload()", "", "", "DP name: " + dpname + ", " + "SR name: " + srname, "Unable to upload. File is empty.");
//        	
//            model.addAttribute("msg4", "Unable to upload. File is empty.");
            return "provisioning";
        }catch (Exception e) {
			// TODO: handle exception
		}
    }
        return "provisioning";
    }
    
    /*								UTILS								*/

//    private void loadPageProvisioning(Model model) {
//    List<ClasificationIpp> clasidications= clasifDao.retrieve();
//    List<SimpleClasificationIPP> categorys= new ArrayList<>();
//    List<SimpleClasificationIPP> clases= new ArrayList<>();
//    List<SimpleClasificationIPP> types= new ArrayList<>();
//    if(clasidications!=null){
//	    for (ClasificationIpp clasif: clasidications) {
//	        SimpleClasificationIPP element=new SimpleClasificationIPP(clasif);
//	        if(element.getType().equals(ClasificationIpp.IPP_CATEGORY))
//	            categorys.add(element);
//	        else if(element.getType().equals(ClasificationIpp.IPP_CLASS))
//	            clases.add(element);
//	        else if(element.getType().equals(ClasificationIpp.IPP_TYPE))
//	            types.add(element);
//	    }
//    }
//	List<com.movasim.dp.model.Keys> dps=(List<com.movasim.dp.model.Keys>) dpdao.retrieveAll();
//	ArrayList<String> dpname= new ArrayList<>();
//	if(dps!=null){
//		for(com.movasim.dp.model.Keys dp :dps)
//			dpname.add(dp.getName());
//	}
//    List<String> listMnoid= new ArrayList<>();
//    List<MNO> mnos=mnodao.retrieveAll();
//    for(MNO mno : mnos){
//    	listMnoid.add(mno.getName());
//    }
//    model.addAttribute("mnoid",listMnoid);
//	model.addAttribute("dp",dpname);
//    model.addAttribute("categoryFound", categorys);
//    model.addAttribute("claseFound", clases);
//    model.addAttribute("typeFound", types);
//	model.addAttribute("sr", srHelper.SrName());
//    }
//   
    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException 
	{
	    File convFile = new File( multipart.getOriginalFilename());
	    multipart.transferTo(convFile);
	    return convFile;
	}
    
//    private void loadSr(String srname,com.movasim.sr.ws.generated.EISType eis){
//        if(srname!=null){
//        PropertyType proper= new PropertyType();
//        proper.setKey("srname");
//        proper.setValue(srname);
//        com.movasim.sr.ws.generated.EISType.AdditionalProperties prop= new AdditionalProperties();
//        prop.getProperty().add(proper);
//        eis.setAdditionalProperties(prop);
//        }
//        ES1Helper.registerEis(eis);
//    }
//    
//    private void loadDp(String dpname, com.movasim.sr.ws.generated.EISType eis){
//    	Card card = cardao.retrieveByEid(Utils.toUnformattedHexArray(eis.getEumSignedInfo().getEid()));
//        if (card == null) {
//        	Card newCard = new Card(eis);
//            newCard.getEumSignedInfo().setPlatformType(dpname);
//            cardao.create(newCard);
//        } else {
//        	Card newCard = new Card(eis);
//            newCard.setId(card.getId());
//            newCard.getEumSignedInfo().setPlatformType(dpname);
//            cardao.update(newCard);
//        }
//    }
//    
//    private PresetCommand SettingsValuesDefaultIPP(String template,String iccid, String imsi, String msisdn,String mnoid, String fileName){
//    	PresetCommand presetCommand=new PresetCommand();
//    	presetCommand.setDescription(template);
//        presetCommand.setInstance("MOVES");
//        presetCommand.setMode("SCP81_SCP03");
//        presetCommand.setIccid(iccid);
//        presetCommand.setImsi(imsi);
//        presetCommand.setMsisdn(msisdn);
//		MNODAO mnodao=new MNODAO();
//		MNO mno=mnodao.retrieveByName(mnoid);
//		if(mno!=null)
//			presetCommand.setMnoid(mno.getMnoid());
//        //presetCommand.setAvailable(available);  con checkbox
//        presetCommand.setAvailable(true);		// sin checkbox
//        presetCommand.setGroup(" ");
//        presetCommand.setCommand(Utils.getFileContent(Settings.getInstance().getFILE_UPLOAD_PATH_IPP() + fileName, true));
//        return presetCommand;
//    }
//    
//    private TemplateIpp SettingsValuesDefaultTemplate(String category, String clase,String type,
//    		String template, Boolean available, String fileName){
//    	TemplateIpp temp= new TemplateIpp();
//    	temp.setCategory(category);
//        temp.setClase(clase);
//        temp.setName(template);
//        temp.setType(type);
//        temp.setDeleted(false);
//        temp.setActive(available);
//        temp.setTemplate(Utils.getFileContent(Settings.getInstance().getFILE_UPLOAD_PATH_TEMPLATE_IPP() + fileName, true));
//    	return temp;
//    }
    
}
