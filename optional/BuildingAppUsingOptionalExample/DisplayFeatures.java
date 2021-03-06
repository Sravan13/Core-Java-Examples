package BuildingAppUsingOptionalExample;

import java.util.Optional;

public class DisplayFeatures {
	
	private String size;
	private Optional<ScreenResolution> resolution;
	
	public DisplayFeatures(String size, Optional<ScreenResolution> resolution){
		this.size = size;
		this.resolution = resolution;
	}
	
	public String getSize() {
		return size;
	}
	
	public Optional<ScreenResolution> getResolutOptional(){
		return resolution;
	}

}
