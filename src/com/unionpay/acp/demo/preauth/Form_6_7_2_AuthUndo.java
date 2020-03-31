package com.unionpay.acp.demo.preauth;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
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
 * 浜ゆ槗锛氶鎺堟潈鎾ら攢锛氬悗鍙颁氦鏄擄紝鏈夊悓姝ュ簲绛斿拰鍚庡彴閫氱煡搴旂瓟<br>
 * 鏃ユ湡锛� 2015-09<br>
 * 鐗堟湰锛� 1.0.0 
 * 鐗堟潈锛� 涓浗閾惰仈<br>
 * 璇存槑锛氫互涓嬩唬鐮佸彧鏄负浜嗘柟渚垮晢鎴锋祴璇曡�屾彁渚涚殑鏍蜂緥浠ｇ爜锛屽晢鎴峰彲浠ユ牴鎹嚜宸遍渶瑕侊紝鎸夌収鎶�鏈枃妗ｇ紪鍐欍�傝浠ｇ爜浠呬緵鍙傝�冿紝涓嶆彁渚涚紪鐮佹�ц兘瑙勮寖鎬х瓑鏂归潰鐨勪繚闅�<br>
 * 璇ユ帴鍙ｅ弬鑰冩枃妗ｄ綅缃細open.unionpay.com甯姪涓績 涓嬭浇  浜у搧鎺ュ彛瑙勮寖  銆婄綉鍏虫敮浠樹骇鍝佹帴鍙ｈ鑼冦��<br>
 *              銆婂钩鍙版帴鍏ユ帴鍙ｈ鑼�-绗�5閮ㄥ垎-闄勫綍銆嬶紙鍐呭寘鍚簲绛旂爜鎺ュ彛瑙勮寖锛屽叏娓犻亾骞冲彴閾惰鍚嶇О-绠�鐮佸鐓ц〃锛�<br>
 * 娴嬭瘯杩囩▼涓殑濡傛灉閬囧埌鐤戦棶鎴栭棶棰樻偍鍙互锛�1锛変紭鍏堝湪open骞冲彴涓煡鎵剧瓟妗堬細
 * 							        璋冭瘯杩囩▼涓殑闂鎴栧叾浠栭棶棰樿鍦� https://open.unionpay.com/ajweb/help/faq/list 甯姪涓績 FAQ 鎼滅储瑙ｅ喅鏂规
 *                             娴嬭瘯杩囩▼涓骇鐢熺殑6浣嶅簲绛旂爜闂鐤戦棶璇峰湪https://open.unionpay.com/ajweb/help/respCode/respCodeList 杈撳叆搴旂瓟鐮佹悳绱㈣В鍐虫柟妗�
 *                          2锛� 鍜ㄨ鍦ㄧ嚎浜哄伐鏀寔锛� open.unionpay.com娉ㄥ唽涓�涓敤鎴峰苟鐧婚檰鍦ㄥ彸涓婅鐐瑰嚮鈥滃湪绾垮鏈嶁�濓紝鍜ㄨ浜哄伐QQ娴嬭瘯鏀寔銆�
 * 浜ゆ槗璇存槑:1锛変互鍚庡彴閫氱煡鎴栦氦鏄撶姸鎬佹煡璇氦鏄擄紙Form_6_5_Query锛夌‘瀹氫氦鏄撴垚鍔熴�傚缓璁彂璧锋煡璇氦鏄撶殑鏈哄埗锛氬彲鏌ヨN娆★紙涓嶈秴杩�6娆★級锛屾瘡娆℃椂闂撮棿闅�2N绉掑彂璧�,鍗抽棿闅�1锛�2锛�4锛�8锛�16锛�32S鏌ヨ锛堟煡璇㈠埌03锛�04锛�05缁х画鏌ヨ锛屽惁鍒欑粓姝㈡煡璇級
 *       2锛夐鎺堟潈鎾ら攢瀵规竻绠楁棩30澶╀箣鍐咃紙鍖呮嫭绗�30澶╋級鐨勯鎺堟潈鍋氾紝蹇呴』涓洪鎺堟潈閲戦鍏ㄩ鎾ら攢銆�
 */
public class Form_6_7_2_AuthUndo extends HttpServlet {

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

		String origQryId = req.getParameter("origQryId");
		String txnAmt = req.getParameter("txnAmt");
		
		Map<String, String> data = new HashMap<String, String>();
		
		/***閾惰仈鍏ㄦ笭閬撶郴缁燂紝浜у搧鍙傛暟锛岄櫎浜唀ncoding鑷閫夋嫨澶栧叾浠栦笉闇�淇敼***/
		data.put("version", DemoBase.version);            //鐗堟湰鍙�
		data.put("encoding", DemoBase.encoding_UTF8);          //瀛楃闆嗙紪鐮� 鍙互浣跨敤UTF-8,GBK涓ょ鏂瑰紡
		data.put("signMethod", "01");                     //绛惧悕鏂规硶 鐩墠鍙敮鎸�01-RSA鏂瑰紡璇佷功鍔犲瘑
		data.put("txnType", "32");                        //浜ゆ槗绫诲瀷 31-棰勬巿鏉冩挙閿�
		data.put("txnSubType", "00");                     //浜ゆ槗瀛愮被鍨�  榛樿00
		data.put("bizType", "000201");                    //涓氬姟绫诲瀷 B2C缃戝叧鏀粯锛屾墜鏈簑ap鏀粯
		data.put("channelType", "07");                    //娓犻亾绫诲瀷锛�07-PC锛�08-鎵嬫満
		
		/***鍟嗘埛鎺ュ叆鍙傛暟***/
		data.put("merId", "777290058161537");             //鍟嗘埛鍙风爜锛岃鏀规垚鑷繁鐢宠鐨勫晢鎴峰彿鎴栬�卭pen涓婃敞鍐屽緱鏉ョ殑777鍟嗘埛鍙锋祴璇�
		data.put("accessType", "0");                      //鎺ュ叆绫诲瀷锛屽晢鎴锋帴鍏ュ浐瀹氬～0锛屼笉闇�淇敼	
		data.put("orderId", DemoBase.getOrderId());       //鍟嗘埛璁㈠崟鍙凤紝8-40浣嶆暟瀛楀瓧姣嶏紝涓嶈兘鍚��-鈥濇垨鈥淿鈥濓紝鍙互鑷瀹氬埗瑙勫垯锛岄噸鏂颁骇鐢燂紝涓嶅悓浜庡師娑堣垂		
		data.put("txnTime", DemoBase.getCurrentTime());   //璁㈠崟鍙戦�佹椂闂达紝鏍煎紡涓篩YYYMMDDhhmmss锛屽繀椤诲彇褰撳墠鏃堕棿锛屽惁鍒欎細鎶xnTime鏃犳晥
		data.put("txnAmt", txnAmt);                       //銆愭挙閿�閲戦銆戯紝鎾ら攢鏃跺繀椤诲拰鍘熸秷璐归噾棰濈浉鍚�	
		data.put("currencyCode", "156");                  //浜ゆ槗甯佺(澧冨唴鍟嗘埛涓�鑸槸156 浜烘皯甯�)
		//data.put("reqReserved", "閫忎紶淇℃伅");                 //璇锋眰鏂逛繚鐣欏煙锛屽闇�浣跨敤璇峰惎鐢ㄥ嵆鍙紱閫忎紶瀛楁锛堝彲浠ュ疄鐜板晢鎴疯嚜瀹氫箟鍙傛暟鐨勮拷韪級鏈氦鏄撶殑鍚庡彴閫氱煡,瀵规湰浜ゆ槗鐨勪氦鏄撶姸鎬佹煡璇氦鏄撱�佸璐︽枃浠朵腑鍧囦細鍘熸牱杩斿洖锛屽晢鎴峰彲浠ユ寜闇�涓婁紶锛岄暱搴︿负1-1024涓瓧鑺�		
		data.put("backUrl", DemoBase.backUrl);            //鍚庡彴閫氱煡鍦板潃锛屽悗鍙伴�氱煡鍙傛暟璇﹁open.unionpay.com甯姪涓績 涓嬭浇  浜у搧鎺ュ彛瑙勮寖  缃戝叧鏀粯浜у搧鎺ュ彛瑙勮寖 娑堣垂鎾ら攢浜ゆ槗 鍟嗘埛閫氱煡,鍏朵粬璇存槑鍚屾秷璐逛氦鏄撶殑鍟嗘埛閫氱煡
		
		/***瑕佽皟閫氫氦鏄撲互涓嬪瓧娈靛繀椤讳慨鏀�***/
		data.put("origQryId", origQryId);   			  //銆愬師濮嬩氦鏄撴祦姘村彿銆戯紝鍘熸秷璐逛氦鏄撹繑鍥炵殑鐨剄ueryId锛屽彲浠ヤ粠娑堣垂浜ゆ槗鍚庡彴閫氱煡鎺ュ彛涓垨鑰呬氦鏄撶姸鎬佹煡璇㈡帴鍙ｄ腑鑾峰彇
		
		
		/**璇锋眰鍙傛暟璁剧疆瀹屾瘯锛屼互涓嬪璇锋眰鍙傛暟杩涜绛惧悕骞跺彂閫乭ttp post璇锋眰锛屾帴鏀跺悓姝ュ簲绛旀姤鏂�**/
		
		Map<String, String> reqData  = AcpService.sign(data,DemoBase.encoding_UTF8);//鎶ユ枃涓璫ertId,signature鐨勫�兼槸鍦╯ignData鏂规硶涓幏鍙栧苟鑷姩璧嬪�肩殑锛屽彧瑕佽瘉涔﹂厤缃纭嵆鍙��
		String url = SDKConfig.getConfig().getBackRequestUrl();//浜ゆ槗璇锋眰url浠庨厤缃枃浠惰鍙栧搴斿睘鎬ф枃浠禷cp_sdk.properties涓殑 acpsdk.backTransUrl
		
		Map<String,String> rspData = AcpService.post(reqData,url,DemoBase.encoding_UTF8);//鍙戦�佽姹傛姤鏂囧苟鎺ュ彈鍚屾搴旂瓟锛堥粯璁よ繛鎺ヨ秴鏃舵椂闂�30绉掞紝璇诲彇杩斿洖缁撴灉瓒呮椂鏃堕棿30绉掞級;杩欓噷璋冪敤signData涔嬪悗锛岃皟鐢╯ubmitUrl涔嬪墠涓嶈兘瀵箂ubmitFromData涓殑閿�煎鍋氫换浣曚慨鏀癸紝濡傛灉淇敼浼氬鑷撮獙绛句笉閫氳繃

		/**瀵瑰簲绛旂爜鐨勫鐞嗭紝璇锋牴鎹偍鐨勪笟鍔￠�昏緫鏉ョ紪鍐欑▼搴�,浠ヤ笅搴旂瓟鐮佸鐞嗛�昏緫浠呬緵鍙傝��------------->**/
		//搴旂瓟鐮佽鑼冨弬鑰僶pen.unionpay.com甯姪涓績 涓嬭浇  浜у搧鎺ュ彛瑙勮寖  銆婂钩鍙版帴鍏ユ帴鍙ｈ鑼�-绗�5閮ㄥ垎-闄勫綍銆�
		if(!rspData.isEmpty()){
			if(AcpService.validate(rspData, DemoBase.encoding_UTF8)){
				LogUtil.writeLog("楠岃瘉绛惧悕鎴愬姛");
				String respCode = rspData.get("respCode");
				if("00".equals(respCode)){
					//浜ゆ槗宸插彈鐞�(涓嶄唬琛ㄤ氦鏄撳凡鎴愬姛锛夛紝绛夊緟鎺ユ敹鍚庡彴閫氱煡纭畾浜ゆ槗鎴愬姛锛屼篃鍙互涓诲姩鍙戣捣 鏌ヨ浜ゆ槗纭畾浜ゆ槗鐘舵�併��
					//TODO
				}else if("03".equals(respCode) ||
						 "04".equals(respCode) ||
						 "05".equals(respCode)){
					//鍚庣画闇�鍙戣捣浜ゆ槗鐘舵�佹煡璇氦鏄撶‘瀹氫氦鏄撶姸鎬併��
					//TODO
				}else{
					//鍏朵粬搴旂瓟鐮佷负澶辫触璇锋帓鏌ュ師鍥�
					//TODO
				}
			}else{
				LogUtil.writeErrorLog("楠岃瘉绛惧悕澶辫触");
				//TODO 妫�鏌ラ獙璇佺鍚嶅け璐ョ殑鍘熷洜
			}
		}else{
			//鏈繑鍥炴纭殑http鐘舵��
			LogUtil.writeErrorLog("鏈幏鍙栧埌杩斿洖鎶ユ枃鎴栬繑鍥瀐ttp鐘舵�佺爜闈�200");
		}
		String reqMessage = DemoBase.genHtmlResult(reqData);
		String rspMessage = DemoBase.genHtmlResult(rspData);
		resp.getWriter().write("</br>璇锋眰鎶ユ枃:<br/>"+reqMessage+"<br/>" + "搴旂瓟鎶ユ枃:</br>"+rspMessage+"");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(req, resp);
	}
}
