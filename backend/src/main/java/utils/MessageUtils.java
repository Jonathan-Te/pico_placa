package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jt.backend.models.History;
import com.jt.backend.models.ValidationObject;

public class MessageUtils {
	public static String setMessageFromResult(History history,ValidationObject validationObject) {
		Date queriedDate = history.getQueriedDate();
		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		DateFormat hourFormat= new SimpleDateFormat("HH:mm");
		String plate=history.getPlate();
		boolean isAllowed = history.isAllowed();
		String message= "El vehículo con placa: "+plate;
		if (!isAllowed) {
			message=message+" NO";
		}
		message=message+" puede circular el día "+ dateFormat.format(queriedDate)+" a las "+hourFormat.format(queriedDate)+"\n";
		
		return message;
	}
}
