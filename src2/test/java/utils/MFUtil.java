package utils;

import java.util.Properties;

import com.ibm.eNetwork.ECL.ECLErr;
import com.ibm.eNetwork.ECL.ECLPS;
import com.ibm.eNetwork.ECL.ECLScreenDesc;
import com.ibm.eNetwork.ECL.ECLSession;

public class MFUtil {
	public static ECLSession session;
	public static ECLPS ps;
	
	public static ECLSession getSession(){
		return session;
	}
	
	public static ECLPS getPs(){
		return ps;
	}

	public static void launchPcomm(String sessionPath) throws ECLErr, InterruptedException{

			sessionPath = System.getProperty("user.dir") + "/" + sessionPath;
            System.loadLibrary("pcseclj");
            
            Properties prop = new Properties();
           //prop.put("SESSION_VT_LOCAL_ECHO ", "true");
            prop.put("SESSION_HOST", sessionPath); 
            prop.put("SESSION_WIN_STATE", "NORMAL");
            prop.put("SESSION_VT_KEYPAD ", "SESSION_VT_KEYPAD_APPL");
            prop.put("SESSION_VT_LOCAL_ECHO", "SESSION_VT_LOCAL_ECHO_ON");

            session = new ECLSession(prop);

            session.StartCommunication(); 
            Thread.sleep(5000);
            session.connect();

            ps=session.GetPS();		
	}
	
	public static void loginFDR(String userid, String password) throws ECLErr, InterruptedException{
		ECLPS ps = getPs();
		char[] txt = new char[1000];

        ECLScreenDesc eclScreen = new ECLScreenDesc();

        eclScreen.SetActive(true);
        
        ps.SendKeys("casn[enter]");
       
        ps.WaitForCursor(1, 2, 3000, true);
        ps.SendKeys("fdsn[enter]");
       
        ps.WaitForCursor(3, 13, 3000, true);
        ps.SendKeys(userid + "[tab]");
        
        ps.SendKeys(password + "[enter]");
        
        ps.WaitForCursor(1,1, 3000, true);
        txt = new char[100];
        ps.GetString( txt, 25, 1, 1, 25);
        System.out.println(txt);
		
	}
	
	public static void logout(){
		session.disconnect();
        session.dispose();
	}
	
	public static String getText(int startRow, int startCol, int endRow, int endCol) throws ECLErr{
		int horizontalStringLength = endCol - startCol+1;
		char[] txt = new char[horizontalStringLength+1];
		String resultString = "";
		for(int i=startRow; i<=endRow; i++){
			ps.GetString( txt, horizontalStringLength, i, startCol, endCol-startCol+1);
			resultString = resultString + String.valueOf(txt);
			resultString = resultString.substring(0, resultString.length()-1);
		}		
		return resultString;
	}
}