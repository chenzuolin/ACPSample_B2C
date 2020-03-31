package com.unionpay.acp.demo.consume;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unionpay.acp.demo.DemoBase;
import com.unionpay.acp.sdk.AcpService;
import com.unionpay.acp.sdk.LogUtil;
import com.unionpay.acp.sdk.SDKConfig;

/**
 * 閲嶈锛氳仈璋冩祴璇曟椂璇蜂粩缁嗛槄璇绘敞閲婏紒
 * 
 * 浜у搧锛氳烦杞綉鍏虫敮浠樹骇鍝�<br>
 * 浜ゆ槗锛氭秷璐癸細鍓嶅彴璺宠浆锛屾湁鍓嶅彴閫氱煡搴旂瓟鍜屽悗鍙伴�氱煡搴旂瓟<br>
 * 鏃ユ湡锛� 2015-09<br>
 * 鐗堟湰锛� 1.0.0
 * 鐗堟潈锛� 涓浗閾惰仈<br>
 * 璇存槑锛氫互涓嬩唬鐮佸彧鏄负浜嗘柟渚垮晢鎴锋祴璇曡�屾彁渚涚殑鏍蜂緥浠ｇ爜锛屽晢鎴峰彲浠ユ牴鎹嚜宸遍渶瑕侊紝鎸夌収鎶�鏈枃妗ｇ紪鍐欍�傝浠ｇ爜浠呬緵鍙傝�冿紝涓嶆彁渚涚紪鐮佹�ц兘瑙勮寖鎬х瓑鏂归潰鐨勪繚闅�<br>
 * 鎻愮ず锛氳鎺ュ彛鍙傝�冩枃妗ｄ綅缃細open.unionpay.com甯姪涓績 涓嬭浇  浜у搧鎺ュ彛瑙勮寖  銆婄綉鍏虫敮浠樹骇鍝佹帴鍙ｈ鑼冦�嬶紝<br>
 *              銆婂钩鍙版帴鍏ユ帴鍙ｈ鑼�-绗�5閮ㄥ垎-闄勫綍銆嬶紙鍐呭寘鍚簲绛旂爜鎺ュ彛瑙勮寖锛屽叏娓犻亾骞冲彴閾惰鍚嶇О-绠�鐮佸鐓ц〃)<br>
 *              銆婂叏娓犻亾骞冲彴鎺ュ叆鎺ュ彛瑙勮寖 绗�3閮ㄥ垎 鏂囦欢鎺ュ彛銆嬶紙瀵硅处鏂囦欢鏍煎紡璇存槑锛�<br>
 * 娴嬭瘯杩囩▼涓殑濡傛灉閬囧埌鐤戦棶鎴栭棶棰樻偍鍙互锛�1锛変紭鍏堝湪open骞冲彴涓煡鎵剧瓟妗堬細
 * 							        璋冭瘯杩囩▼涓殑闂鎴栧叾浠栭棶棰樿鍦� https://open.unionpay.com/ajweb/help/faq/list 甯姪涓績 FAQ 鎼滅储瑙ｅ喅鏂规
 *                             娴嬭瘯杩囩▼涓骇鐢熺殑6浣嶅簲绛旂爜闂鐤戦棶璇峰湪https://open.unionpay.com/ajweb/help/respCode/respCodeList 杈撳叆搴旂瓟鐮佹悳绱㈣В鍐虫柟妗�
 *                          2锛� 鍜ㄨ鍦ㄧ嚎浜哄伐鏀寔锛� open.unionpay.com娉ㄥ唽涓�涓敤鎴峰苟鐧婚檰鍦ㄥ彸涓婅鐐瑰嚮鈥滃湪绾垮鏈嶁�濓紝鍜ㄨ浜哄伐QQ娴嬭瘯鏀寔銆�
 * 浜ゆ槗璇存槑:1锛変互鍚庡彴閫氱煡鎴栦氦鏄撶姸鎬佹煡璇氦鏄撶‘瀹氫氦鏄撴垚鍔�,鍓嶅彴閫氱煡涓嶈兘浣滀负鍒ゆ柇鎴愬姛鐨勬爣鍑�.
 *       2锛変氦鏄撶姸鎬佹煡璇氦鏄擄紙Form_6_5_Query锛夊缓璁皟鐢ㄦ満鍒讹細鍓嶅彴绫讳氦鏄撳缓璁棿闅旓紙5鍒嗐��10鍒嗐��30鍒嗐��60鍒嗐��120鍒嗭級鍙戣捣浜ゆ槗鏌ヨ锛屽鏋滄煡璇㈠埌缁撴灉鎴愬姛锛屽垯涓嶇敤鍐嶆煡璇€�傦紙澶辫触锛屽鐞嗕腑锛屾煡璇笉鍒拌鍗曞潎鍙兘涓轰腑闂寸姸鎬侊級銆備篃鍙互寤鸿鍟嗘埛浣跨敤payTimeout锛堟敮浠樿秴鏃舵椂闂达級锛岃繃浜嗚繖涓椂闂寸偣鏌ヨ锛屽緱鍒扮殑缁撴灉涓烘渶缁堢粨鏋溿��
 */
public class Form_6_2_FrontConsume extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		/**
		 * 璇锋眰閾惰仈鎺ュ叆鍦板潃锛岃幏鍙栬瘉涔︽枃浠讹紝璇佷功璺緞绛夌浉鍏冲弬鏁板垵濮嬪寲鍒癝DKConfig绫讳腑
		 * 鍦╦ava main 鏂瑰紡杩愯鏃跺繀椤绘瘡娆￠兘鎵ц鍔犺浇
		 * 濡傛灉鏄湪web搴旂敤寮�鍙戦噷,杩欎釜鏂规硶鍙娇鐢ㄧ洃鍚殑鏂瑰紡鍐欏叆缂撳瓨,鏃犻』鍦ㄨ繖鍑虹幇
		 */
		//杩欓噷宸茬粡灏嗗姞杞藉睘鎬ф枃浠剁殑鏂规硶鎸埌浜唚eb/AutoLoadServlet.java涓�
		//SDKConfig.getConfig().loadPropertiesFromSrc(); //浠巆lasspath鍔犺浇acp_sdk.properties鏂囦欢
		super.init();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//鍓嶅彴椤甸潰浼犺繃鏉ョ殑
		String merId = req.getParameter("merId");
		String txnAmt = req.getParameter("txnAmt");
		
		Map<String, String> requestData = new HashMap<String, String>();
		
		/***閾惰仈鍏ㄦ笭閬撶郴缁燂紝浜у搧鍙傛暟锛岄櫎浜唀ncoding鑷閫夋嫨澶栧叾浠栦笉闇�淇敼***/
		requestData.put("version", DemoBase.version);   			  //鐗堟湰鍙凤紝鍏ㄦ笭閬撻粯璁ゅ��
		requestData.put("encoding", DemoBase.encoding_UTF8); 			  //瀛楃闆嗙紪鐮侊紝鍙互浣跨敤UTF-8,GBK涓ょ鏂瑰紡
		requestData.put("signMethod", "01");            			  //绛惧悕鏂规硶锛屽彧鏀寔 01锛歊SA鏂瑰紡璇佷功鍔犲瘑
		requestData.put("txnType", "01");               			  //浜ゆ槗绫诲瀷 锛�01锛氭秷璐�
		requestData.put("txnSubType", "01");            			  //浜ゆ槗瀛愮被鍨嬶紝 01锛氳嚜鍔╂秷璐�
		requestData.put("bizType", "000201");           			  //涓氬姟绫诲瀷锛孊2C缃戝叧鏀粯锛屾墜鏈簑ap鏀粯
		requestData.put("channelType", "07");           			  //娓犻亾绫诲瀷锛岃繖涓瓧娈靛尯鍒咮2C缃戝叧鏀粯鍜屾墜鏈簑ap鏀粯锛�07锛歅C,骞虫澘  08锛氭墜鏈�
		
		/***鍟嗘埛鎺ュ叆鍙傛暟***/
		requestData.put("merId", merId);    	          			  //鍟嗘埛鍙风爜锛岃鏀规垚鑷繁鐢宠鐨勬寮忓晢鎴峰彿鎴栬�卭pen涓婃敞鍐屽緱鏉ョ殑777娴嬭瘯鍟嗘埛鍙�
		requestData.put("accessType", "0");             			  //鎺ュ叆绫诲瀷锛�0锛氱洿杩炲晢鎴� 
		requestData.put("orderId",DemoBase.getOrderId());             //鍟嗘埛璁㈠崟鍙凤紝8-40浣嶆暟瀛楀瓧姣嶏紝涓嶈兘鍚��-鈥濇垨鈥淿鈥濓紝鍙互鑷瀹氬埗瑙勫垯		
		requestData.put("txnTime", DemoBase.getCurrentTime());        //璁㈠崟鍙戦�佹椂闂达紝鍙栫郴缁熸椂闂达紝鏍煎紡涓篩YYYMMDDhhmmss锛屽繀椤诲彇褰撳墠鏃堕棿锛屽惁鍒欎細鎶xnTime鏃犳晥
		requestData.put("currencyCode", "156");         			  //浜ゆ槗甯佺锛堝鍐呭晢鎴蜂竴鑸槸156 浜烘皯甯侊級		
		requestData.put("txnAmt", txnAmt);             			      //浜ゆ槗閲戦锛屽崟浣嶅垎锛屼笉瑕佸甫灏忔暟鐐�
		//requestData.put("reqReserved", "閫忎紶瀛楁");        		      //璇锋眰鏂逛繚鐣欏煙锛屽闇�浣跨敤璇峰惎鐢ㄥ嵆鍙紱閫忎紶瀛楁锛堝彲浠ュ疄鐜板晢鎴疯嚜瀹氫箟鍙傛暟鐨勮拷韪級鏈氦鏄撶殑鍚庡彴閫氱煡,瀵规湰浜ゆ槗鐨勪氦鏄撶姸鎬佹煡璇氦鏄撱�佸璐︽枃浠朵腑鍧囦細鍘熸牱杩斿洖锛屽晢鎴峰彲浠ユ寜闇�涓婁紶锛岄暱搴︿负1-1024涓瓧鑺�		
		
		//鍓嶅彴閫氱煡鍦板潃 锛堥渶璁剧疆涓哄缃戣兘璁块棶 http https鍧囧彲锛夛紝鏀粯鎴愬姛鍚庣殑椤甸潰 鐐瑰嚮鈥滆繑鍥炲晢鎴封�濇寜閽殑鏃跺�欏皢寮傛閫氱煡鎶ユ枃post鍒拌鍦板潃
		//濡傛灉鎯宠瀹炵幇杩囧嚑绉掍腑鑷姩璺宠浆鍥炲晢鎴烽〉闈㈡潈闄愶紝闇�鑱旂郴閾惰仈涓氬姟鐢宠寮�閫氳嚜鍔ㄨ繑鍥炲晢鎴锋潈闄�
		//寮傛閫氱煡鍙傛暟璇﹁open.unionpay.com甯姪涓績 涓嬭浇  浜у搧鎺ュ彛瑙勮寖  缃戝叧鏀粯浜у搧鎺ュ彛瑙勮寖 娑堣垂浜ゆ槗 鍟嗘埛閫氱煡
		requestData.put("frontUrl", DemoBase.frontUrl);
		
		//鍚庡彴閫氱煡鍦板潃锛堥渶璁剧疆涓恒�愬缃戙�戣兘璁块棶 http https鍧囧彲锛夛紝鏀粯鎴愬姛鍚庨摱鑱斾細鑷姩灏嗗紓姝ラ�氱煡鎶ユ枃post鍒板晢鎴蜂笂閫佺殑璇ュ湴鍧�锛屽け璐ョ殑浜ゆ槗閾惰仈涓嶄細鍙戦�佸悗鍙伴�氱煡
		//鍚庡彴閫氱煡鍙傛暟璇﹁open.unionpay.com甯姪涓績 涓嬭浇  浜у搧鎺ュ彛瑙勮寖  缃戝叧鏀粯浜у搧鎺ュ彛瑙勮寖 娑堣垂浜ゆ槗 鍟嗘埛閫氱煡
		//娉ㄦ剰:1.闇�璁剧疆涓哄缃戣兘璁块棶锛屽惁鍒欐敹涓嶅埌閫氱煡    2.http https鍧囧彲  3.鏀跺崟鍚庡彴閫氱煡鍚庨渶瑕�10绉掑唴杩斿洖http200鎴�302鐘舵�佺爜 
		//    4.濡傛灉閾惰仈閫氱煡鏈嶅姟鍣ㄥ彂閫侀�氱煡鍚�10绉掑唴鏈敹鍒拌繑鍥炵姸鎬佺爜鎴栬�呭簲绛旂爜闈瀐ttp200锛岄偅涔堥摱鑱斾細闂撮殧涓�娈垫椂闂村啀娆″彂閫併�傛�诲叡鍙戦��5娆★紝姣忔鐨勯棿闅旀椂闂翠负0,1,2,4鍒嗛挓銆�
		//    5.鍚庡彴閫氱煡鍦板潃濡傛灉涓婇�佷簡甯︽湁锛熺殑鍙傛暟锛屼緥濡傦細http://abc/web?a=b&c=d 鍦ㄥ悗鍙伴�氱煡澶勭悊绋嬪簭楠岃瘉绛惧悕涔嬪墠闇�瑕佺紪鍐欓�昏緫灏嗚繖浜涘瓧娈靛幓鎺夊啀楠岀锛屽惁鍒欏皢浼氶獙绛惧け璐�
		requestData.put("backUrl", DemoBase.backUrl);
		
		//////////////////////////////////////////////////
		//
		//       鎶ユ枃涓壒娈婄敤娉曡鏌ョ湅 PCwap缃戝叧璺宠浆鏀粯鐗规畩鐢ㄦ硶.txt
		//
		//////////////////////////////////////////////////
		
		/**璇锋眰鍙傛暟璁剧疆瀹屾瘯锛屼互涓嬪璇锋眰鍙傛暟杩涜绛惧悕骞剁敓鎴恏tml琛ㄥ崟锛屽皢琛ㄥ崟鍐欏叆娴忚鍣ㄨ烦杞墦寮�閾惰仈椤甸潰**/
		Map<String, String> submitFromData = AcpService.sign(requestData,DemoBase.encoding_UTF8);  //鎶ユ枃涓璫ertId,signature鐨勫�兼槸鍦╯ignData鏂规硶涓幏鍙栧苟鑷姩璧嬪�肩殑锛屽彧瑕佽瘉涔﹂厤缃纭嵆鍙��
		
		String requestFrontUrl = SDKConfig.getConfig().getFrontRequestUrl();  //鑾峰彇璇锋眰閾惰仈鐨勫墠鍙板湴鍧�锛氬搴斿睘鎬ф枃浠禷cp_sdk.properties鏂囦欢涓殑acpsdk.frontTransUrl
		String html = AcpService.createAutoFormHtml(requestFrontUrl, submitFromData,DemoBase.encoding_UTF8);   //鐢熸垚鑷姩璺宠浆鐨凥tml琛ㄥ崟
		
		LogUtil.writeLog("鎵撳嵃璇锋眰HTML锛屾涓鸿姹傛姤鏂囷紝涓鸿仈璋冩帓鏌ラ棶棰樼殑渚濇嵁锛�"+html);
		//灏嗙敓鎴愮殑html鍐欏埌娴忚鍣ㄤ腑瀹屾垚鑷姩璺宠浆鎵撳紑閾惰仈鏀粯椤甸潰锛涜繖閲岃皟鐢╯ignData涔嬪悗锛屽皢html鍐欏埌娴忚鍣ㄨ烦杞埌閾惰仈椤甸潰涔嬪墠鍧囦笉鑳藉html涓殑琛ㄥ崟椤圭殑鍚嶇О鍜屽�艰繘琛屼慨鏀癸紝濡傛灉淇敼浼氬鑷撮獙绛句笉閫氳繃
		resp.getWriter().write(html);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}	
}
