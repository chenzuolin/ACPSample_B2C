package WeiXin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;





public class XMLUtil {
	 /**
     * ����xml,���ص�һ��Ԫ�ؼ�ֵ�ԡ������һ��Ԫ�����ӽڵ㣬��˽ڵ��ֵ���ӽڵ��xml���ݡ�
     * @param strxml
     * @return
     * @throws JDOMException
     * @throws IOException
     */
	public static SortedMap doXMLParse(String strxml) throws JDOMException, IOException {
		strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");
		if(null == strxml || "".equals(strxml)) {
		return null;
		}
		SortedMap m = new TreeMap();
		InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(in);
		Element root = doc.getRootElement();
		List list = root.getChildren();
		Iterator it = list.iterator();
		while(it.hasNext()) {
		Element e = (Element) it.next();
		String k = e.getName();//�ڵ�����
		String v = "";
		List children = e.getChildren();
		if(children.isEmpty()) {
		v = e.getTextNormalize();
		} else {
		v = getChildrenText(children);
		}
		m.put(k, v);
		}
		//�ر���
		in.close();
		return m;
		}
    /**
     * ��ȡ�ӽ���xml
     * @param children
     * @return String
     */
    public static String getChildrenText(List children) {
        StringBuffer sb = new StringBuffer();
        if(!children.isEmpty()) {
            Iterator it = children.iterator();
            while(it.hasNext()) {
                Element e = (Element) it.next();
                String name = ((org.jdom.Element) e).getName();
                String value = ((org.jdom.Element) e).getTextNormalize();
                List list = ((org.jdom.Element) e).getChildren();
                sb.append("<" + name + ">");
                if(!list.isEmpty()) {
                    sb.append(XMLUtil.getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }

        return sb.toString();
    }


}
