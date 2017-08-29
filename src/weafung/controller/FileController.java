package weafung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("/File")
public class FileController {
    @RequestMapping(value = "/Upload", method = RequestMethod.GET)
    public String showUploadPage() {
        return "upload";
    }

    @RequestMapping(value = "/Upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file, Model model, HttpServletRequest request) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"
                        + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(filePath));
                model.addAttribute("msg", "上传成功: " + filePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "upload";
    }
}
