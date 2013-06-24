package ch.lepeit.brain2;

public class VersionInfo {

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getArtefaktBudleId() {
        return artefaktBudleId;
    }

    public void setArtefaktBudleId(String artefaktBudleId) {
        this.artefaktBudleId = artefaktBudleId;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    String stageName;

    String artefaktBudleId;

    String serverUrl;

}
