package View;

import java.io.IOException;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ClassGenerator;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MethodGenerator;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.TypeCheckError;

import sun.security.x509.AuthorityKeyIdentifierExtension;
import Controllers.Authorization;
import Controllers.ReadFun;
import Models.User;
import Controllers.MyHandler;

public class TemplateView {
	
	static public String patternForRegUser(String templ) throws IOException{
         	
         	if(!Authorization.user.getLogin().equals("???"))
     		return templ.replace("%user_name%", "Hello, "+Authorization.user.getUserName());
        
         		return templ.replace("%user_name%", "");
         }
	
	static public String patternForRegPage(String templ) throws IOException{
		String response = "";
		response = templ.replace("%content%", ReadFun.readFromFile("regPage.html"));
		return response;
	}
	
	static public String patternForBadReg(String templ) throws IOException{
		String response = "";
		response = templ.replace("%content%", ReadFun.readFromFile("badReg.html"));
		
		return response;
	}
}

