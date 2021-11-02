package com.webapp.cloud.EC2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EC2Info {

	 @Value("${local-ipv4:N/A}")
	    private String internalIPAddress;

	    @Value("${public-ipv4:N/A}")
	    private String externalIPAddress;

	    @Value("${instance-id:N/A}")
	    private String instanceId;

	    @Value("${s3_name:N/A}")
	    private String firstDataOption;
	    
	    public String getData() {
	        return firstDataOption;
	    }

	    public void setData(String internalIPAddress) {
	        this.firstDataOption = internalIPAddress;
	    }

	    public String getInternalIPAddress() {
	        return internalIPAddress;
	    }

	    public void setInternalIPAddress(String internalIPAddress) {
	        this.internalIPAddress = internalIPAddress;
	    }

	    public String getExternalIPAddress() {
	        return externalIPAddress;
	    }

	    public void setExternalIPAddress(String externalIPAddress) {
	        this.externalIPAddress = externalIPAddress;
	    }

	    public String getInstanceId() {
	        return instanceId;
	    }

	    public void setInstanceId(String instanceId) {
	        this.instanceId = instanceId;
	    }

	    @Override
	    public String toString() {
	        return "EC2InstanceInfo{" +
	                "internalIPAddress='" + internalIPAddress + '\'' +
	                ", externalIPAddress='" + externalIPAddress + '\'' +
	                ", instanceId='" + instanceId + '\'' +
	                '}';
	    }
	
}
