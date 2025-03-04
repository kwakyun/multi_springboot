package org.example.boot12_rest_member;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("api/member")
public class MemberRestController {


	@GetMapping("/selectAll")
	public List<MemberVO> selectAll() {
		log.info("/member/selectAll");
		List<MemberVO> vos = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			MemberVO vo = new MemberVO();
			vo.setNum(i);
			vo.setId("id" + i);
			vo.setPw("pw" + i);
			vo.setName("name" + i);
			vo.setTel("tel" + i);
			vos.add(vo);
		}
		return vos;
	}
	
	@GetMapping("/selectOne")
	public String selectOne(MemberVO vo) {
		log.info("/member/selectOne");
		log.info("vo = " + vo);

        MemberVO vo2 = new MemberVO();   // 넘어오는 것은 vo ,넘기는 것은 vo2
        vo2.setNum(1);
		vo2.setId("id" + 11);
		vo2.setPw("pw" + 11);
		vo2.setName("name" + 11);
		vo2.setTel("tel" + 11);

		return "member/selectOne";
	}
	
	@PostMapping("/insertOK")
	public Map<String,Object> insertOK(@RequestBody MemberVO vo) {
		log.info("/member/insertOK");
		log.info("vo:{}",vo);

		Map<String,Object> map = new HashMap<>();
		map.put("result",1);
		return map;
	}
	
	@PutMapping("/updateOK")
	public Map<String,Object> updateOK(@RequestBody MemberVO vo) {
		log.info("/member/updateOK");
		log.info("vo:{}",vo);

		Map<String,Object> map = new HashMap<>();
		map.put("result",1);
		return map;
	}
	
	@DeleteMapping("/deleteOK")
	public Map<String,Object> deleteOK(MemberVO vo) {
		log.info("/member/deleteOK");
		log.info("vo:{}",vo);

		Map<String,Object> map = new HashMap<>();
		map.put("result",1);
		return map;
	}
	@PostMapping("/idCheck")
	public Map<String,Object> idCheck(MemberVO vo) {
		log.info("/member/idCheck");
		log.info("vo:{}",vo);

		Map<String,Object> map = new HashMap<>();
		map.put("result","OK");
		return map;
	}


}//end class
