package org.example.mybatis_file_security.member;

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
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService service;

    @Value("${file.dir}")
    private String realPath;

    @Autowired
    private HttpSession session;

    @GetMapping("/insert")
    public String insert() {
        log.info("/member/insert");
        return "member/insert";
    }

    @GetMapping("/update")
    public String update(MemberVO vo, Model model) {
        log.info("/member/update");
        log.info("vo : {}",vo);

        MemberVO vo2 = service.selectOne(vo);
        model.addAttribute("vo2", vo2);

        return "member/update";
    }

    @GetMapping("/delete")
    public String delete() {
        log.info("/member/delete");

        return "member/delete";
    }

    @GetMapping("/selectOne")
    public String selectOne(MemberVO vo, Model model) {
        log.info("/member/selectOne");
        log.info("vo : {}",vo);

        MemberVO vo2 = service.selectOne(vo);
        model.addAttribute("vo2", vo2);

        return "member/selectOne";
    }

    @GetMapping("/selectAll")
    public String selectAll(
            @RequestParam(defaultValue = "1")int cpage,
            @RequestParam(defaultValue = "5")int limit, Model model) {
        log.info("/member/selectAll");
        log.info("cpage: {}",cpage);
        log.info("limit: {}",limit);

        List<MemberVO> vos = service.selectAll(cpage, limit);
        model.addAttribute("vos", vos);


        return "member/selectAll";
    }

    @GetMapping("/searchList")
    public String searchList(
            @RequestParam(defaultValue = "1")int cpage,
            @RequestParam(defaultValue = "5")int limit,
            @RequestParam(defaultValue = "name")String searchKey,
            @RequestParam(defaultValue = "")String searchWord,
            Model model ) {
        log.info("/member/searchList");
        log.info("cpage: {}",cpage);
        log.info("limit: {}",limit);
        log.info("searchKey: {}",searchKey);
        log.info("searchWord: {}",searchWord);

        List<MemberVO> vos = service.searchList(cpage, limit, searchKey, searchWord);
        model.addAttribute("vos", vos);

        return "member/selectAll";
    }

    @PostMapping("/insertOK")
    public String insertOK(MemberVO vo) throws IOException {
        log.info("/member/insertOK");
        log.info("vo : {}",vo);


        log.info("realPath : {}",realPath);

        String originName = vo.getFile().getOriginalFilename();
        log.info("originName : {}",originName);

        if(originName.length() == 0){//파일첨부안되었을때는 기본이미지이름으로 설정.
            vo.setImgname("default.png");
        }else{
            //중복파일명 배제하는 처리. ex: img_387483924732743.png
            String save_name = "img_"+ System.currentTimeMillis()+originName.substring(originName.lastIndexOf("."));
            log.info("save_name : {}",save_name);
            vo.setImgname(save_name);//디비에 들어갈 이미지명 세팅

            File f = new File(realPath,save_name);
            vo.getFile().transferTo(f);//파일 저장...

            //작은이미지로 만들어서 저장하기
            //// create thumbnail image/////////
            BufferedImage original_buffer_img = ImageIO.read(f);
            BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
            Graphics2D graphic = thumb_buffer_img.createGraphics();
            graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

            File thumb_file = new File(realPath, "thumb_" + save_name);

            ImageIO.write(thumb_buffer_img, save_name.substring(save_name.lastIndexOf(".") + 1), thumb_file);
        }//end if

        int result = service.insertOK(vo);
        log.info("result : {}",result);

        if(result  > 0) {
            return "redirect:/member/selectAll";
        }else{
            return "redirect:/member/insert";
        }
    }

    @PostMapping("/updateOK")
    public String updateOK(MemberVO vo) throws IOException {
        log.info("/member/updateOK");
        log.info("vo : {}",vo);


        log.info("realPath : {}",realPath);

        String originName = vo.getFile().getOriginalFilename();
        log.info("originName : {}",originName);

        if(originName.length() == 0){//파일첨부 안되었을때는 이전 이미지이름으로 설정.
            vo.setImgname(vo.getImgname());
        }else{
            //중복파일명 배제하는 처리. ex: img_387483924732743.png
            String save_name = "img_"+ System.currentTimeMillis()+originName.substring(originName.lastIndexOf("."));
            log.info("save_name : {}",save_name);
            vo.setImgname(save_name);//디비에 들어갈 이미지명 세팅

            File f = new File(realPath,save_name);
            vo.getFile().transferTo(f);//파일 저장...

            //작은이미지로 만들어서 저장하기
            //// create thumbnail image/////////
            BufferedImage original_buffer_img = ImageIO.read(f);
            BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
            Graphics2D graphic = thumb_buffer_img.createGraphics();
            graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

            File thumb_file = new File(realPath, "thumb_" + save_name);

            ImageIO.write(thumb_buffer_img, save_name.substring(save_name.lastIndexOf(".") + 1), thumb_file);
        }//end if


        int result = service.updateOK(vo);
        log.info("result : {}",result);

        if(result  > 0) {
            return "redirect:/member/selectOne?num="+vo.getNum();
        }else{
            return "redirect:/member/update?num="+vo.getNum();
        }
    }

    @GetMapping("/deleteOK")
    public String deleteOK(MemberVO vo) {
        log.info("/member/deleteOK");
        log.info("vo : {}",vo);

        int result = service.deleteOK(vo);
        log.info("result : {}",result);

        if(result  > 0) {
            return "redirect:/member/selectAll";
        }else{
            return "redirect:/member/delete?num="+vo.getNum();
        }
    }


    @GetMapping("/login_form")
    public String login_form() {
        log.info("/member/login_form");

        return "member/login_form";
    }

    @GetMapping("/required_login")
    public String required_login() {
        log.info("/member/required_login");

        return "member/login_form";
    }

    //주의 : 로그인시 POST전송으로 제출되기때문에 실패시에도 그대로 @PostMapping으로 처리해야함
    @PostMapping("/login_fail")
    public String login_fail() {
        log.info("/member/login_fail");

        return "member/login_fail";
    }

    //주의 : 로그인시 POST전송으로 제출되기때문에 성공시에도 그대로 @PostMapping으로 처리해야함
    @PostMapping("/login_success")
    public String login_success() {
        log.info("/member/login_success");
        //로그인 성공 후 보여질 페이지
        return "redirect:/home";
    }

    @GetMapping("/denied")
    public String denied() {
        log.info("/member/denied");
        return "member/denied";
    }

    @GetMapping("/expired")
    public String expired() {
        log.info("/member/expired");
        return "member/expired";
    }


    @GetMapping("/selectOneMyPage")
    public String selectOneMyPage(Model model) {
        log.info("/member/selectOneMyPage");
        //마이페이지로부터는 회원번호가 넘어오지 않기때문에 세션으로부터 아이디를 얻어서 검색.
        String user_id = session.getAttribute("user_id").toString();
        MemberVO vo2 = service.selectOneMyPage(user_id);

        model.addAttribute("vo2", vo2);

        return "member/selectOne";
    }

}//end class
