package ch.lepeit.brain2;

public class Installiere {

    // die Sachen, die vom gui kommen:



    String serverUrl;

    String neueVersion;

    String artefaktBundleId;

    String stageKurzName;

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String server) {
        this.serverUrl = server;
    }

    public String getNeueVersion() {
        return neueVersion;
    }

    public void setNeueVersion(String neueversion) {
        this.neueVersion = neueversion;
    }

    public String getArtefaktBundleId() {
        return artefaktBundleId;
    }

    public void setArtefaktBundleId(String artefakt) {
        this.artefaktBundleId = artefakt;
    }

    public String getStageKurzName() {
        return stageKurzName;
    }

    public void setStageKurzName(String stage) {
        this.stageKurzName = stage;
    }

}
