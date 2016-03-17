package katse.valuuta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import katse.valuuta.obj.Tulemus;
import katse.valuuta.obj.Valuuta;
import katse.valuuta.service.ValuutaService;

@Controller
public class ValuutaController {
	
	@Autowired
	ValuutaService valuutaService;
	
	// Selles rakenduses kasutame ainult ühte kontrolleri meetodit
	@RequestMapping({"/"})
	public ModelAndView valuuta(
			@RequestParam(value = "summa", required = false) String summa,
			@RequestParam(value = "from", required = false) String from,
			@RequestParam(value = "to", required = false) String to,
			@RequestParam(value = "kp", required = false) String kp,
			@RequestParam(value = "cal", required = false) String cal) {
		
		String startMessage = "Uus valuutakalkulaator";
		
		List<Valuuta> valuutad = valuutaService.getAllValuutad();
		// TODO: paneme sessiooni ja uuesti ei küsi
		
		Tulemus tulemus = new Tulemus();
		if(cal != null){
			tulemus = valuutaService.kalkuleeri(new Tulemus(summa, from, to, kp), false);
		}
		
		if(kp == null || kp.equals("")) kp = "2010-12-30";
		
		ModelAndView mv = new ModelAndView("valuuta");
		mv.addObject("startMessage", startMessage);
		mv.addObject("valuutad", valuutad);
		mv.addObject("msg", tulemus.msg);
		mv.addObject("error", tulemus.error);
		mv.addObject("summa", summa);
		mv.addObject("from", from);
		mv.addObject("to", to);
		mv.addObject("kp", kp);
		mv.addObject("tulemusKursCaption", tulemus.tulemusKursCaption);
		mv.addObject("tulemusSummaCaption", tulemus.tulemusSummaCaption);
		mv.addObject("tulemused", tulemus.tulemused);
		
		return mv;		
	}

}
