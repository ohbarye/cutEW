package controllers;


import models.request.makeShift.ConditionRequest;
import models.service.makeShift.MakeShiftService;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import static play.data.Form.*;

/**
 * シフト作成画面用 Controller
 * @author ohbarye
 */
public class MakeShiftController extends Controller {

	/**
	 * シフト作成画面初期表示処理。
	 * @return
	 */
    public static Result index() {
        return ok(views.html.makeShift.index.render(initializedForm()));
    }
	
	/**
	 * シフトを作成する処理です。
	 * @return
	 */
    public static Result makeShift() {
    	Form<ConditionRequest> form = form(ConditionRequest.class).bindFromRequest();

    	if (!form.hasErrors()) {
    		Logger.info("帳票を出力します");
    		// 出力条件から帳票を作成する
    		return ok(MakeShiftService.makeShift(form.get()));
    		
    	} else {
    		flash("error","入力内容にエラーがあります");
    		return ok(views.html.makeShift.index.render(form));
    	}
    }
	
    /**
     * 初期表示用にFormを初期化します。
     * @return
     */
    private static Form<ConditionRequest> initializedForm() {
    	ConditionRequest form = new ConditionRequest();
    	form.openingTime = "09:00";
    	form.closingTime = "18:00";
    	form.shiftSystem = "1";
    	return form(ConditionRequest.class).fill(form);
    }
	
}
