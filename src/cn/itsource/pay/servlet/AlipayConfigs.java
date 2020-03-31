package cn.itsource.pay.servlet;

public class AlipayConfigs {




	public static String app_id = "2018121862569391";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="\r\n" + 
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
			"l6JaIZh+IPsC3N1FYorEjun/pu1jPg6OVT227g45XgnPdJiQHCqa5fsu  uQKBgQCL\r\n" + 
			"Uz7di2d6C6iKFq2BuMFF0J0Y/XnBw9cxfOvFhMGuRGc8ROi4XdwTXnT9Rb9mNZY4\r\n" + 
			"C9YkrziEC6g3wh8k0dFiwZ/UxyYd8HDI4VP/0BJtE/Hqc9Ms4YhP4s7zgvZNuuR4\r\n" + 
			"i53gsmzx2H3A50DWG+RqF+C6Af+qe8P35kq3u+4tbQKBgGmJoQz14Op3lc4ro9f8\r\n" + 
			"VUcgyVmDDw0XIMwmH6uDvp1GhWgOGjXefTuxPAY4J5FD3BaZiFA8LzomO6mU+znM\r\n" + 
			"/AgAqmwqwGTVWHNvCWPUk5vILXcn6lV8OztFzqHSYEBKhdiRjWDlx4Nctih3Nb3k\r\n" + 
			"T6C0JxyM70zctAGz1jbBW+Gl\r\n" + 
			"";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhBezXUSnxXC/gsrn1ozdo8x6/kDy04ouiavmSow3So+K1TaOwWlcThgMRvm6kAezz6dtR+aZnUImbyv6b/z/xyui9P5voy9u3IeL+VqpfTJgBx9/X+Bk7Hlu+AsDvdGVt1D2qHtM6OOR9tqcY8iRshUD/FEmP++uMKUqvPs23BiP6znv9O/l6uGeNrpQA/QF/FFR5KrIebmrR8BQbBUkx4lziiHgrq0DFFpsqDmw0MT8dwnLrn+ZOxJYHXZH+95/4XMLmvJO38I3/xYrUAi2/eBhBTu9So+DnNi6/syCayVupXPmjiV1xN/OQouhxxr0cP5pK75WZrXkjr+KhFYLRwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://www.sumengkx.com/ACPSample_B2C/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://www.sumengkx.com/ACPSample_B2C/success.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	
	// 支付宝网关
	

}