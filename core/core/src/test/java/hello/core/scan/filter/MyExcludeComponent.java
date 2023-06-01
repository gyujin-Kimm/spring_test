package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)       // 중요.. 클래스 타입에 붙는다.
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
    // 얘가 붙은 거는 componentScan에 제외하는 것.
}
