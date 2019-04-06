package network.models;

	public class ReportModel {

		private String device_id;
		private String network_id;
		private float throughput;
		
		public ReportModel() {
			// TODO Auto-generated constructor stub
		}
		
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
		public float getThroughput() {
			return throughput;
		}
		public void setThroughput(float throughput) {
			this.throughput = throughput;
		}
		
	}
