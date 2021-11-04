package BuildingAppUsingOptionalExample;

import java.util.Optional;

public class MobileService {
	
	public Integer getMobileScreenWidth(Optional<Mobile> mobile){
		
		return mobile.flatMap(Mobile::getDisplayFeatures)
				.flatMap(DisplayFeatures :: getResolutOptional)
				.map(ScreenResolution::getWidth)
				.orElse(0);
	}

}
