package org.example.demo_travel.travel;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/travel")
public class TravelController {

    @Autowired
    private TravelService service;

    @Value("${file.dir}")
    private String realPath;

    @Autowired
    private HttpSession session;

    @GetMapping("/insert")
    public String insert() {
        log.info("/travel/insert");
        return "travel/insert";
    }

    @GetMapping("/update")
    public String update(TravelVO vo, Model model) {
        log.info("/travel/update");
        log.info("vo : {}",vo);

        TravelVO vo2 = service.selectOne(vo);
        model.addAttribute("vo2", vo2);

        return "travel/update";
    }

    @GetMapping("/delete")
    public String delete() {
        log.info("/travel/delete");

        return "travel/delete";
    }

    @GetMapping("/selectOne")
    public String selectOne(TravelVO vo, Model model) {
        log.info("/travel/selectOne");
        log.info("vo : {}",vo);

        TravelVO vo2 = service.selectOne(vo);
        model.addAttribute("vo2", vo2);

        return "travel/selectOne";
    }

    @GetMapping("/selectAll")
    public String selectAll(
            @RequestParam(defaultValue = "1")int cpage,
            @RequestParam(defaultValue = "5")int limit, Model model) {
        log.info("/travel/selectAll");
        log.info("cpage: {}",cpage);
        log.info("limit: {}",limit);

        List<TravelVO> vos = service.selectAll(cpage, limit);
        model.addAttribute("vos", vos);


        return "travel/selectAll";
    }

    @GetMapping("/searchList")
    public String searchList(
            @RequestParam(defaultValue = "1")int cpage,
            @RequestParam(defaultValue = "5")int limit,
            @RequestParam(defaultValue = "district")String searchKey,
            @RequestParam(defaultValue = "")String searchWord,
            Model model ) {
        log.info("Controller :  /travel/searchList");
        log.info("cpage: {}",cpage);
        log.info("limit: {}",limit);
        log.info("searchKey: {}",searchKey);
        log.info("searchWord: {}",searchWord);


        List<TravelVO> vos = service.searchList(cpage, limit, searchKey, searchWord);
        log.info("vos: {}",vos);
        model.addAttribute("vos", vos);


        return "travel/selectAll";
    }

    @PostMapping("/insertOK")
    public String insertOK(TravelVO vo) throws IOException {
        log.info("/travel/insertOK");
        log.info("vo : {}",vo);

        log.info("reapPath : {}",realPath);
        String originName = vo.getFile().getOriginalFilename();
        log.info("originName : {}",originName);

        if(originName.length()==0){ //파일첨부 안되었을때는 기본이미지 이름으로 설정
            vo.setImgname("default.png");
        }else{
            //중복파일명 배제하는 처리. ex: img_354364745745
            String save_name = "img+" + System.currentTimeMillis() + originName.substring(originName.lastIndexOf("."));
            log.info("save name : {}",save_name);
            vo.setImgname(save_name); //디비에 들어갈 이미지명 세팅

            File f = new File(realPath+save_name);
            vo.getFile().transferTo(f); //파일 저장...

            //작은 이미지로 만들어서 저장하기
            // create thumbnail image
            BufferedImage original_buffer_img = ImageIO.read(f);
            BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
            Graphics2D graphic = thumb_buffer_img.createGraphics();
            graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

            File thumb_file = new File(realPath,"thumb_" + save_name);

            ImageIO.write(thumb_buffer_img, save_name.substring(save_name.lastIndexOf(".")+1), thumb_file);


        }



        int result = service.insertOK(vo);
        log.info("result : {}",result);

        if(result  > 0) {
            return "redirect:/travel/selectAll";
        }else{
            return "redirect:/travel/insert";
        }
    }

    @PostMapping("/updateOK")
    public String updateOK(TravelVO vo) throws IOException {
        log.info("/travel/updateOK");
        log.info("vo : {}",vo);


        log.info("realPath: {}",realPath);

        String originName = vo.getFile().getOriginalFilename();
        log.info("originName : {}",originName);

        if(originName.length()==0){ //파일 첨부 안되었을때는 이전 이미지 이름으로 설정
            vo.setImgname(vo.getImgname());
        }else{
            //중복파일명 배제하는 처리. ex: img_436435w73151.png
            String save_name = "img+" + System.currentTimeMillis() + originName.substring(originName.lastIndexOf("."));
            log.info("save name : {}",save_name);
            vo.setImgname(save_name); //디비에 들어갈 이미지명 세팅

            File f = new File(realPath,save_name);
            vo.getFile().transferTo(f); //파일 저장...

            //작은이미지로 만들어서 저장하기
            // create thumbnail image
            BufferedImage original_buffer_img = ImageIO.read(f);
            BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
            Graphics2D graphic = thumb_buffer_img.createGraphics();
            graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

            File thumb_file = new File(realPath,"thumb_" + save_name);

            ImageIO.write(thumb_buffer_img, save_name.substring(save_name.lastIndexOf(".")+1), thumb_file );

        }




        int result = service.updateOK(vo);
        log.info("result : {}",result);

        if(result  > 0) {
            return "redirect:/travel/selectOne?no="+vo.getNo();
        }else{
            return "redirect:/travel/update?no="+vo.getNo();
        }
    }

    @GetMapping("/deleteOK")
    public String deleteOK(TravelVO vo) {
        log.info("/travel/deleteOK");
        log.info("vo : {}",vo);

        int result = service.deleteOK(vo);
        log.info("result : {}",result);

        if(result  > 0) {
            return "redirect:/travel/selectAll";
        }else{
            return "redirect:/travel/delete?no="+vo.getNo();
        }
    }



}//end class