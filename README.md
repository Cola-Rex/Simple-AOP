# Simple-AOP
a happy AOP

切面（Aspect）:
`切面包含了通知和切点，通知和切点共同定义了切面是什么，在何时，何处执行切面逻辑。`

通知（Advice）:
```通知定义了要织入目标对象的逻辑，以及执行时机。
Spring 中对应了 5 种不同类型的通知：
· 前置通知（Before）：在目标方法执行前，执行通知
· 后置通知（After）：在目标方法执行后，执行通知，此时不关系目标方法返回的结果是什么
· 返回通知（After-returning）：在目标方法执行后，执行通知
· 异常通知（After-throwing）：在目标方法抛出异常后执行通知
· 环绕通知（Around）: 目标方法被通知包裹，通知在目标方法执行前和执行后都被会调用
```

切点（Pointcut）:
`如果说通知定义了在何时执行通知，那么切点就定义了在何处执行通知。
所以切点的作用就是通过匹配规则查找合适的连接点（Joinpoint），AOP 会在这些连接点上织入通知。`

这里 AOP 是基于 JDK 动态代理实现的，只需3步即可完成：
 1. 定义一个包含切面逻辑的对象，这里假设叫 logMethodInvocation
 2. 定义一个 Advice 对象（实现了 InvocationHandler 接口），并将上面的 logMethodInvocation 和 目标对象传入
 3. 将上面的 Adivce 对象和目标对象传给 JDK 动态代理方法，为目标对象生成代理
 

AOP 的代码结构:
 - MethodInvocation 接口  // 实现类包含了切面逻辑，如上面的 logMethodInvocation
 - Advice 接口        // 继承了 InvocationHandler 接口
 - BeforeAdvice 类    // 实现了 Advice 接口，是一个前置通知
 - SimpleAOP 类       // 生成代理类
 - SimpleAOPTest      // SimpleAOP 从测试类
 - HelloService 接口   // 目标对象接口
 - HelloServiceImpl   // 目标对象
