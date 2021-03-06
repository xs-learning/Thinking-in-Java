import code_list_three.*;

public class 第十五章 {
    /*
     * 第十五章:
     * 	·泛型："适合于许多许多的类型"
     * 	·多态算是一种泛化机制。有时候即便是使用了接口，对程序的约束也是太强。因为一旦指明了接口，它就要求你的代码必须使用特定的接口。而我们希望达到的目的是编写更通用的
     * 		代码，要使代码能够应用于"某种不具体的类型"，而不是一个具体的接口或类。
     * 	·javaSE 5.0 的重大变化:泛型的概念，泛型实现了参数化类型的概念，使代码可以应用多种类型。
     */

    /*
     * ·简单的泛型
     *  ·有很多原因促成了泛型的出现，而最引人注目的一个就是为了创造 容器类 。容器，就是存放对象的地方
     *  ·java泛型的核心概念:告诉编译器想使用什么类型，编译器帮你处理一切细节。
     */
    Holder1 holder1;

    /*
     * ·一个元组类库
     * 	·有时候你需要仅一次方法调用就能返回多个对象，但是return只能返回一个对象，通常你会创建一个对象，让他来持有多个对象，你可能需要创建专门的类来完成这样的工作
     * 		有了泛型之后，我们可以一次的解决这个问题。
     * 	·这个概念叫 元组 ，它是将  一组对象直接打包  存储于其中 的一个 单一对象。这个容器对象允许你读取其中的元素，但是不允许你 向其中 存储新的对象
     */
    TwoTuple twoTuple;

    /*
     * ·一个堆栈类(Stack)
     * 	·Stack<T>和LinkedList<T>的组合来创建
     */
    LinkedStack linkedStack;//自己自定义一个链表存储机制
    RamdomList ramdomList;//RandomList

    /*
     * ·泛型接口
     */
    Coffee coffee;//泛型接口用作 生成器
    Fibonacci fibonacci;

    /*
     * ·泛型方法
     * 	·是否拥有泛型方法，与其所在的类是否是泛型没有关系
     * 	·泛型方法使得该方法独立与类而产生的变化，一个指导原则：无论何时，尽量使用泛型方法
     * 	·对于一个static的方法而言，无法访问泛型类的类型参数，所以，如果static方法需要使用泛型的能力，就必须使其成为泛型方法
     * 	·定义一个泛型方法:将泛型参数列表置于返回值之前
     * 		像这样:
     * 			public <T> void f(T t) {}
     * 	·注意：使用泛型类必须在创建对象的时候指定参数类型，而在使用泛型方法时，通常不必指明参数类型。因为编译器会帮我们找出具体的类型，这称 类型参数推断
     */
    GenericMethod genericMethod;

    /*
     * ·杠杆利用类型参数推断
     */
    New n;

    /*
     * ·可变参数与泛型方法
     */
    GenericVarargs genericVarargs;

    /*
     * ·用于Generator的泛型方法
     * 	·利用生成器可以很方便地填充一个Collection(这是上面学的)。而泛型这种操作是具有实际意义的(泛型是现在学的，写出更加通用的代码)
     */
    Generators generators;

    /*
     * ·一个通用的Generator(对象生成器)
     * 	·下面的程序可以为任何类构造一个Generator(对象生成器)。为了减少类型声明，提供了一个泛型方法。
     */
    BasicGenerator basicGenerator;

    /*
     * ·简单元组的使用
     */
    Tuple tuple;

    /*
     * ·匿名内部类
     * 	·泛型还可以应用在匿名内部类
     */
    BankTeller bkTeller;

    /*
     * ·擦除的神秘之处
     * 	·当你深入研究泛型时，你会发现有大量的东西初看起来是没有意义的。例如，尽管可以声明为ArrayList.class，但是不能声明为ArrayList<Integer>.class
     * 		因为声明为ArrayList<Integer>.class 中的 <Integer>是没有任何意义的。在编译器后<Integer>是没有的，是被擦除的。
     *  ·java泛型是使用擦除来实现的，这意味着当你在使用泛型的时，任何具体的  类型信息  都被擦除了，你唯一知道的就是你在使用一个对象。
     *  	因此List<String>和List<Integer>在运行时  事实上是相同的类型的。这两种形式都被擦除成它们的"原生"的类型
     *  ·C++的方式：看下面。理解C++的泛型也有一定的好处
     */
    ErasedTypeEquivalence e;//ArrayList<Integer>和ArrayList<String>是同一个类型
    LostInformation L;//无法获得 类型参数的 具体信息，更无法通过类型参数创建它的Class对象
    CPulsPuls cPulsPuls;//C++使用的模板  与  java泛型 的区别，跟java的泛型很一样

    /*
     * ·迁移兼容性<下面都是围绕这个话题来说>
     * 	·为了减少潜在的关于 擦除 的混乱，你必须认识到这不是一个语言的特征，它是java泛型实现中的一种折中。因为泛型不是java语言出现时就有的组成成分，所以这种折中是必须的
     * 	·如果泛型是java1.0就已经是其一部分了，那么这个特征将不会使用擦除来是实现--它将使用具体化，使类型参数保持为第一类实体，这样的话你就可以在类型参数上执行基于
     * 		类型语言的操作和反射操作。擦除  减少了泛型的泛化性，泛型咋java中仍然是有用的，只是不如它们本来设想的那么有用，其原因就是擦除
     * 	·在基于擦除的实现中，泛型类型被当作第二类类型来处理，既不能在重要的上下文环境中使用 类型。泛型类型只有在  静态类型  检查期间才出现，在此之后，程序中所有的泛型类型都被
     * 		擦除了，替换为它们的非泛型上界。例如：诸如List<T>这样的类型注解将被擦除为List，而普通的类型变量在未指定边界的情况下将被擦除为Object
     *  ·擦除的核心动机是它使得泛化的客户端可以用非泛化的类库来使用，反之亦然。这经常被称为"迁移兼容性"
     *  	因为在理想情况下，当所有的事物都可以使用泛化，那我们就可以专注于此。但是在现实中，5.0之前是没有泛型的，必须要处理这些没有被泛化的类库
     *  ·因此java泛型不仅必须支持向后兼容性，即现有的代码是合法的，并且继续保持之前的含义。而且还要支持迁移兼容性，使得旧的代码不会影响新的代码
     *  	一句话就是允许非泛型代码与泛型代码共存，擦除 使得这种向着泛型的迁移成为可能
     */

    /*
     * ·擦除的问题
     * 	·擦除的主要的正当理由是从非泛化代码到泛化代码的转变过程，以及在不破环现有类库的情况下，将泛型融入java语言。擦除使得现有的非泛型客户端代码能够在不改变的情况继续使用
     * 		直到客户端准备好用泛型重写这些代码。这是一个崇高的动机，因为他不会突然间破环所有现有的代码
     * 	·擦除的代价是显著的，泛型不能用于显式地引用运行时类型的操作之中。因为所有关于参数的类型信息都丢失了。
     * 	·无论何时，当你在编写泛型代码的时候，必须时刻提醒自己，你只是看起来 好像拥有了 有关类型的信息。其实它只不过是一个Object而已
     * 	·泛型不是强制的
     * 	·当你希望将类型参数不要仅仅当作是Obbject处理时，就需要付出额外努力来管理边界(例如通过编写这些<T extends HasF>来管理)
     * 	·其他编程语言的参数化类型相比(例如C++)：通常比java得心应手，它们的参数化类型机制比java的更灵活，更强大
     */
    ErasureAndInheritance e1;

    /*
     * ·边界处的动作
     * 	·因为擦除，泛型最令人困惑的一方面源自这样的一个事实，，即可以表示没有任何意义的事物。
     * 	·泛型中的所有动作都发生在边界
     */
    ArrayMaker arrayMaker;

    /*
     * ·擦除的补偿
     * 	·擦除丢失了在泛型代码中执行某些操作的能力。在任何时候需要知道确切的类型信息的操作都将无法工作
     * 	·创建类型实例
     */
    InstantiateGenericType instantiateGenericType;


    public static void main(String[] args) {

        /*
         * 练习
         */
        test1();
    }

    private static void test1() {

    }

    ObjectA objectA;
    ObjectB objectB;
    ObjectC objectC;//extend关键字的是使用
}
