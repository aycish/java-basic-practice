package designpattern.proxy;

import java.util.concurrent.atomic.AtomicLong;

import designpattern.proxy.aop.AopBrowser;

public class ProxyTest {
	public static void main(String[] args) {
		IBrowser oBrowser = new Browser("www.tmaxsoft.com");
		oBrowser.show();
		/* cache되어 있지 않기 때문에, 매번 생성하여 받아온다.
		oBrowser.show();
		oBrowser.show();
		oBrowser.show();
		oBrowser.show();
		oBrowser.show();
		*/

		/* cache 사용 */
		IBrowser iBrowser = new BrowserProxy("www.tmaxsoft.com");
		iBrowser.show();
		iBrowser.show();
		iBrowser.show();
		iBrowser.show();
		iBrowser.show();
		iBrowser.show();

		/* AOP 사용해보기 (전/후처리) */
		AtomicLong start = new AtomicLong();
		AtomicLong end = new AtomicLong();

		IBrowser aBrowser = new AopBrowser("www.tmaxsoft.com",
			()-> {
				System.out.println("before");
				start.set(System.currentTimeMillis());

			},
			()-> {
				end.set(System.currentTimeMillis() - start.get());
			});

		aBrowser.show();
		System.out.println("loading time : " + end.get());

		aBrowser.show();
		System.out.println("loading time : " + end.get());
		aBrowser.show();
		System.out.println("loading time : " + end.get());
		aBrowser.show();
		System.out.println("loading time : " + end.get());
	}
}
