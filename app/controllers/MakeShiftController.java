package controllers;

import java.util.List;

import models.request.makeShift.ConditionChoices;
import models.request.makeShift.ConditionRequest;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.ConfigUtil;
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
    		flash("success","帳票を出力します");
    		return ok(views.html.makeShift.index.render(form));
    	} else {
    		flash("error","入力内容にエラーがあります");
    		return ok(views.html.makeShift.index.render(form));
    	}
    }
	
    private static Form<ConditionRequest> initializedForm() {
    	ConditionRequest form = new ConditionRequest();
    	form.openingTime = "09:00";
    	form.closingTime = "18:00";
    	form.shiftSystem = "1";
    	return form(ConditionRequest.class).fill(form);
    }
	
}
