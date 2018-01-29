package com.lgg.nticxs.utils;

/**
 * Created by movasim on 09/09/16.
 */
import java.io.FileInputStream;
import java.util.Properties;


public class Settings {
	private WSLogger logger = new WSLogger();
	
	private Properties propertiesWEB;
    private static Settings instance = null;

    private String FILE_UPLOAD_PATH_CARDS;
    private String FILE_UPLOAD_PATH_IPP;
    private String FILE_UPLOAD_PATH_TEMPLATE_IPP;
    private String FILE_UPLOAD_PATH_PERSONALISATION_IPP;
    private String FILE_UPLOAD_PATH_MSISDNS;
    private String nameMsisds;
    private String DP_URL;
    private String SR_URL;
    private String usValid;
    private String passValid;
    private String usMovasim;
    private String passMovasim;
    private String usTenant;
    private String passTenant;
    private String iccidName;
    private String imsiName;
    private String msisdnName;
	private String parameterToDecrypted;
	private String keyMovasim;
	private String path_logCcm;
	private String path_logDp;
	private String path_logSr;
	private boolean mutualAuth;
	private String keystore;
	private String keystoreAlias;
	private String keystorePass;
	private String queueName;
	private String movasimDBName;
	private String movasimPathCurl;

	private Settings() {
        this.load();
    }

    public static Settings getInstance() {
        if (instance==null) {
            instance = new Settings();
        }
        return instance;
    }


    public void load() {
        propertiesWEB = new Properties();
        try {
            propertiesWEB.load(new FileInputStream("/var/movasim/nticxs-web.properties"));
            this.FILE_UPLOAD_PATH_CARDS = propertiesWEB.getProperty("uploadCards");
            this.FILE_UPLOAD_PATH_IPP = propertiesWEB.getProperty("uploadIpp");
            this.FILE_UPLOAD_PATH_TEMPLATE_IPP = propertiesWEB.getProperty("uploadTemplate");
            this.FILE_UPLOAD_PATH_PERSONALISATION_IPP = propertiesWEB.getProperty("uploadPersonalisation");
            this.FILE_UPLOAD_PATH_MSISDNS = propertiesWEB.getProperty("msisdsn");
            this.DP_URL = propertiesWEB.getProperty("urlDp");
            this.SR_URL = propertiesWEB.getProperty("urlSr");
            this.usValid = propertiesWEB.getProperty("usValid");
            this.passValid = propertiesWEB.getProperty("passValid");
            this.usMovasim = propertiesWEB.getProperty("usMovasim");
            this.passMovasim = propertiesWEB.getProperty("passMovasim");
            this.usTenant = propertiesWEB.getProperty("usTenant");
            this.passTenant = propertiesWEB.getProperty("passTenant");
            this.iccidName = propertiesWEB.getProperty("iccidName");
            this.imsiName = propertiesWEB.getProperty("imsiName");
            this.msisdnName = propertiesWEB.getProperty("msisdnName");
			this.parameterToDecrypted=propertiesWEB.getProperty("parameterToDecrypted");
			this.keyMovasim = propertiesWEB.getProperty("keyMovasim");
			this.path_logCcm = propertiesWEB.getProperty("path_logCcm");
			this.path_logDp = propertiesWEB.getProperty("path_logDp");
			this.path_logSr = propertiesWEB.getProperty("path_logSr");
			this.mutualAuth = Boolean.parseBoolean(propertiesWEB.getProperty("mutualauth"));
			this.keystore = propertiesWEB.getProperty("keystore");
			this.keystoreAlias = propertiesWEB.getProperty("keystorealias");
			this.keystorePass = propertiesWEB.getProperty("keystorepass");
			this.queueName = propertiesWEB.getProperty("queueName");
			this.movasimDBName = propertiesWEB.getProperty("movasimDBName");
			this.movasimPathCurl = propertiesWEB.getProperty("movasimPathCurl");
        } catch (Exception e) {

            logger.logger("ERROR", "SM-WEB", "Persistence", "", "", "load()", "", "", "", "Cannot load the properties file");
            
            e.printStackTrace();
        }
    }

    public String getFILE_UPLOAD_PATH_CARDS() {
        return FILE_UPLOAD_PATH_CARDS;
    }

    public String getFILE_UPLOAD_PATH_IPP(){
        return FILE_UPLOAD_PATH_IPP;
    }

    public String getDP_URL(){
        return  DP_URL;
    }

    public String getSR_URL(){
        return SR_URL;
    }

    public String getUsValid() {
        return usValid;
    }

    public String getPassValid() {
        return passValid;
    }

    public String getUsMovasim() {
        return usMovasim;
    }

    public String getFILE_UPLOAD_PATH_MSISDNS() {
		return FILE_UPLOAD_PATH_MSISDNS;
	}

	public String getPassMovasim() {
        return passMovasim;
    }

    public String getUsTenant() {
        return usTenant;
    }
    

    public String getPath_logCcm() {
		return path_logCcm;
	}

	public String getPath_logDp() {
		return path_logDp;
	}

	public String getPath_logSr() {
		return path_logSr;
	}

	public String getPassTenant() {
        return passTenant;
    }

	public String getQueueName() {
		return queueName;
	}

	public String getKeyMovasim() {
		return keyMovasim;
	}
	
	public String getParameterToDecrypted() {
		return parameterToDecrypted;
	}
	
    public String getFILE_UPLOAD_PATH_TEMPLATE_IPP() {
        return FILE_UPLOAD_PATH_TEMPLATE_IPP;
    }

    public String getFILE_UPLOAD_PATH_PERSONALISATION_IPP() {
        return FILE_UPLOAD_PATH_PERSONALISATION_IPP;
    }

    public String getIccidName() {
        return iccidName;
    }

    public String getImsiName() {
        return imsiName;
    }

    public String getNameMsisds() {
		return nameMsisds;
	}

	public String getMsisdnName() {
        return msisdnName;
    }

	public boolean isMutualAuth() {
		return mutualAuth;
	}

	public String getKeystore() {
		return keystore;
	}

	public String getKeystoreAlias() {
		return keystoreAlias;
	}

	public String getKeystorePass() {
		return keystorePass;
	}
	
	public String getMovasimDBName() {
		return movasimDBName;
	}
	
	public String getMovasimPathCurl() {
		return movasimPathCurl;
	}
}
