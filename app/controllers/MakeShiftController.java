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
    	Form<ConditionRequest> form = form(ConditionRequest.class);
        return ok(views.html.makeShift.index.render(form));
    }
	
	/**
	 * シフトを作成する処理です。
	 * @return
	 */
    public static Result makeShift() {
    	Form<ConditionRequest> form = form(ConditionRequest.class).bindFromRequest();
//        return ok(views.html.makeShift.index.render(form));
    	return TODO;
    }
	
	
}
