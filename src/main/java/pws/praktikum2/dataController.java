/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.praktikum2;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author aldy ahmad fauzi
 */
@Controller
public class dataController {
    
    @RequestMapping("/data")
    public String form(@RequestParam(value = "variableA") String name,
            @RequestParam(value = "variableB") String location,
            @RequestParam(value = "variableC") MultipartFile photo,
            Model antar)
            
            
    throws IOException{
        
        byte[] imge = photo.getBytes();
        String base64 = Base64.encodeBase64String(imge);
        String gambar = "data:image/png;base64".concat(base64);
        
        antar.addAttribute("antar1", name);
        antar.addAttribute("antar2", location);
        antar.addAttribute("antar3", gambar);
        
        return "viewhalaman";
         
        
    }
    
    
}
