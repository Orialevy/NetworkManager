package network.models;
public class DeviceModel {
	private String device_id;
	private String network_id;
	private String auth;

	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getNetwork_id() {
		return network_id;
	}
	public void setNetwork_id(String network_id) {
		this.network_id = network_id;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}	
}
