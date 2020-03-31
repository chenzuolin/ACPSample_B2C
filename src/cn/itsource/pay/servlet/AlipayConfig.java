package cn.itsource.pay.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

public class AlipayConfig {

	public static String partner = "2088331674573481";

	 // 6.请求网关地址
	    public static String URL = "https://openapi.alipay.com/gateway.do";    

	    public static String service = "mobile.securitypay.pay";//固定值

	    public static String seller_id = "*******@163.com";
	    //私钥
	    public static String private_key = "\r\n" + 
				"MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDIAAYSg1FGZSxJ\r\n" + 
				"aBYRYAeQ59KN60kAtaAHVqt0lB6YXM7TgXn0Vg/l9cEupkfeqoDR5hFBeqoVNTDG\r\n" + 
				"8gPy5aHR+STgHc8hf57ks3x4MWqr0G02vk1NrGaV38kO/Xm6elF54J2dNBDUNZeE\r\n" + 
				"g1FKzzHHHEA8fn9GbtooWxjaAwOgsJZ8RDLwS2OulElWq7e6JMCSiPJeCWDnNMzd\r\n" + 
				"8B493Ceob9vuf5cQjmG/mLTEz4Yhwe7cQqUskn8vZhYppp+PpamOhahr6UL+n1P8\r\n" + 
				"2Xx0Zc+JI5tg5z2fepqivTFKcCl3ZK/xVkZgT2YXUoZx+Pj6rx4sTBREtpeVfWVm\r\n" + 
				"fRNMCXE7AgMBAAECggEBAJUNP3lImKfH+utyQRAN61WZD5hpA20d7vfJJdqqEOso\r\n" + 
				"L5P9aLAp+4s8Tg7AKcvOclb8CVwtWNiZXZLHBx5c+O6NqWfFj3q9q+NxyI+i9Ia7\r\n" + 
				"vMkRpnb+xy1nLGaZjcDmLBaSyaRBC1G75wIBA/Km28gyS8VJ2Pza3Ic67Rh9KpTz\r\n" + 
				"9MHJ4F75pNd3dS1gBL+LMWt2IB8PbbPwattLOYGm4TyXn6gL9nXoGLFJddPL7c+a\r\n" + 
				"vUHwr/p3s0x1p59HH5bw6o7JFNVo4xoTcjsnLjKNF9tkP/G4YnAJL5W2263Q89nZ\r\n" + 
				"Hl0dKV6lLBF4QCjAahtGoDW3KIVZbhkKMQ9+EG/obmECgYEA5hFQE9EIdCo4jIsf\r\n" + 
				"AbOuSN4iphHJwoPHHhzL56dYx+rFat7aZogfIMWNvsrDKgYR8k7koT96TSqmOYVU\r\n" + 
				"6TTqOoZre0dsNbVRnVOiOsV81XaJxp8tMVL8lpwlBqeVnz9LDzgW8BdfcUtOi/Vb\r\n" + 
				"YqEGZJHqiksAS5k6o0uiqFtZMvkCgYEA3osZ2SfTaQcRC1aWRUuzq+fPPkwP6wVV\r\n" + 
				"mXnWT731NluNjL90OMtHxcPuDdGImpEnlH8fFm7EqMmhzqyF9uWFg06RxBIv3/7k\r\n" + 
				"15hB/o2MDiplcQ4foBfkQZt9UBZsS1QoTXfZCyU1jDT0/XK6MLimc/QjTSwyiqjT\r\n" + 
				"qUMqAN11XtMCgYAf711HMufSgB3TXGhUayWRFcyHcsanynT0OBkRscgAEBWRLRfx\r\n" + 
				"zYlMmj9/sVN/3NHW6Z6Qx2fpmDb0mw5bRK4Sq5/1v8dEeUO36+kD8W/PjaG4QVYb\r\n" + 
				"l6JaIZh+IPsC3N1FYorEjun/pu1jPg6OVT227g45XgnPdJiQHCqa5fsuuQKBgQCL\r\n" + 
				"Uz7di2d6C6iKFq2BuMFF0J0Y/XnBw9cxfOvFhMGuRGc8ROi4XdwTXnT9Rb9mNZY4\r\n" + 
				"C9YkrziEC6g3wh8k0dFiwZ/UxyYd8HDI4VP/0BJtE/Hqc9Ms4YhP4s7zgvZNuuR4\r\n" + 
				"i53gsmzx2H3A50DWG+RqF+C6Af+qe8P35kq3u+4tbQKBgGmJoQz14Op3lc4ro9f8\r\n" + 
				"VUcgyVmDDw0XIMwmH6uDvp1GhWgOGjXefTuxPAY4J5FD3BaZiFA8LzomO6mU+znM\r\n" + 
				"/AgAqmwqwGTVWHNvCWPUk5vILXcn6lV8OztFzqHSYEBKhdiRjWDlx4Nctih3Nb3k\r\n" + 
				"T6C0JxyM70zctAGz1jbBW+Gl\r\n" + 
				"";
	    // 商户的公钥钥
	    public static String public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1i3ItYkvlERqf1StsPPS9ZVSAVi+GJKksFPJu4ltJWBIcfeT9kAbfKupI1pRJZyry1+/rcN1enq0SJyTrrYB6Jw9gNZxEPrWawGZGkbEA9b+3Chw6MxxhzA5botB86qV9b8d/I/OSEZU4QHJIdVY6JR+sABGTMIcPftBnmc0oZ6aUIN1Q/HW8WoeUs+5w3Kyb3AcNcd9q7MfGqQeaXMvUb1kF8FUOMO3zEe3Q91xZLj2efGR1f3HXOFb3RYX7KbNqHR1be40551gotvkTr1p5sQhh2U+J+gIDnTedNaxuWyrrT92yQixsn+olIV/RBUsfxWwjK/P440nBJs/0WnevQIDAQAB";
	    // 支付宝的公钥，无需修改该值（不要删除也不要修改，在接收通知的时候需要进行签名认证）
	    public static String ali_public_key= "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhBezXUSnxXC/gsrn1ozdo8x6/kDy04ouiavmSow3So+K1TaOwWlcThgMRvm6kAezz6dtR+aZnUImbyv6b/z/xyui9P5voy9u3IeL+VqpfTJgBx9/X+Bk7Hlu+AsDvdGVt1D2qHtM6OOR9tqcY8iRshUD/FEmP++uMKUqvPs23BiP6znv9O/l6uGeNrpQA/QF/FFR5KrIebmrR8BQbBUkx4lziiHgrq0DFFpsqDmw0MT8dwnLrn+ZOxJYHXZH+95/4XMLmvJO38I3/xYrUAi2/eBhBTu9So+DnNi6/syCayVupXPmjiV1xN/OQouhxxr0cP5pK75WZrXkjr+KhFYLRwIDAQAB";

	    // 字符编码格式 目前支持 gbk 或 utf-8
	    public static String input_charset = "utf-8";
	    // 签名方式 不需修改
	    public static String sign_type = "RSA2";

	    //APPID
	    public static String APPID = "2018121862569391";    
	   //支付宝回调地址 
	    public static String notify_url = "http://www.sumengkx.com/ACPSample_B2C/NoServlet1";

	    // 8.返回格式
	   public static String FORMAT = "json";
	   public static String url="http://www.sumengkx.com/ACPSample_B2C/AlipayNorServlet";

}