package network.managers;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import network.models.DeviceModel;
import network.models.ReportModel;
import network.models.WifiNetwork;

@Component
public class NetworkManager {
	
	// thread safe map
	ConcurrentHashMap<String, WifiNetwork> networks;
	
	public NetworkManager() {
		networks = new ConcurrentHashMap<String, WifiNetwork>();
	}
	
	public WifiNetwork FetchNetwork(String id, HttpServletResponse response) {
		if(networks == null || !networks.containsKey(id)) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			return null;
		}
		
		return networks.get(id);
	}
	
	public WifiNetwork ConnectToNetwork(DeviceModel device, HttpServletResponse response) {
		
		WifiNetwork network = networks.get(device.getNetwork_id());
		if(network == null) {
			network = CreateNetwork(device.getNetwork_id(), device.getAuth());
		}
		else{
			if(!network.getAuth().equals(device.getAuth())) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			if(DoesDeviceExist(device, network.getDevices())) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
		}
	
		network.addDevice(device);
		return network;
	}
	
	public String ReportNetworkThroughput(ReportModel report, HttpServletResponse response) {
		WifiNetwork network = networks.get(report.getNetwork_id());
		if(network == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return "error";
		}
		
		network.setAvg_throughput(network.getAvg_throughput() + report.getThroughput());
		return "ok";
	}
	
	private WifiNetwork CreateNetwork(String networkId, String auth) {
		WifiNetwork newNetwork = new WifiNetwork();
		newNetwork.setId(networkId);
		newNetwork.setAuth(auth);
		newNetwork.setAvg_throughput(0);
		networks.put(networkId, newNetwork);
		
		return newNetwork;
	}
	
	public boolean DoesDeviceExist(DeviceModel device, List<DeviceModel> devices) {
		for(DeviceModel currDevice : devices) {
			if(currDevice.getDevice_id().equals(device.getDevice_id())) {
				return true;
			}
		}
		return false;
	}
}