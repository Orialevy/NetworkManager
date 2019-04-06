package network.models;
import java.util.ArrayList;
import java.util.List;

public class WifiNetwork{
		private String id;
		private String auth;
		private float avg_throughput;
		private List<DeviceModel> devices;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getAuth() {
			return auth;
		}
		public void setAuth(String auth) {
			this.auth = auth;
		}
		public float getAvg_throughput() {
			return avg_throughput;
		}
		public void setAvg_throughput(float avg_throughput) {
			this.avg_throughput = avg_throughput;
		}
		public List<DeviceModel> getDevices() {
			return devices;
		}
		public void addDevice(DeviceModel device) {
			if(devices == null) {
				devices = new ArrayList<DeviceModel>();
			}
			devices.add(device);
		}
	}