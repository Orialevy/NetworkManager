package network.controllers;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import network.managers.NetworkManager;
import network.models.DeviceModel;
import network.models.ReportModel;
import network.models.WifiNetwork;

@RestController
@RequestMapping("/my-service/api/network")
public class WifiController {
	@Resource
	private NetworkManager networkManager; 
	
	@GetMapping("")
    public WifiNetwork FetchNetwork(@RequestParam("id") String id, HttpServletResponse response) {
		return networkManager.FetchNetwork(id, response);		        
    }
	
	@PutMapping("/connect")
    public WifiNetwork connectDeviceToNetwork(@RequestBody DeviceModel device, HttpServletResponse response) {
		return networkManager.ConnectToNetwork(device, response);         
    }

	@PostMapping("/report")
    public String reportNetworkThroughput( @RequestBody ReportModel report, HttpServletResponse response) {
		return networkManager.ReportNetworkThroughput(report, response);
    }
}
