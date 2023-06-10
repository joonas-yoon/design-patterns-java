# 싱글턴 패턴 (Singleton Pattern)

## 정의

> 클래스에 인스턴스가 하나만 있도록 하면서 이 인스턴스에 대한 전역 접근(액세스) 지점을 제공하는 생성 디자인 패턴

내용이 무척 간결하고 많은 곳에서 사용되고 있는 패턴 중 하나이다.

## 사례

어떤 어플리케이션(`Application`)의 데이터베이스(`Database`)를 구현하고자 한다.

모든 어플리케이션은 동일한 하나의 데이터베이스를 사용해야 한다.

그리고 데이터베이스는 2개 이상 생성될 수가 없어야 한다.

## 이슈

`Database`를 생성하고, `Application`이 로그를 남기는 상황을 생각해보자.

```java
Database db = new Database();

application1.addLog(db.currentTime());

db.update();

application2.addLog(db.currentTime());
```

위와 같이 파라미터로 전달해서 같은 `Database` 객체를 사용하도록 할 수 있지만, 클래스가 깊어진다면 파라미터가 너무 많아질 수 있다.

결과적으로는 아래와 같이 코드가 구현되기를 원하는 상황이다.

```java
class Application {
    void addLog() {
        // TODO: db는 어디서나 항상 같은 객체를 가져온다.
        Database db = new Database();
        // ...
        logging.add(currentUsers);
        logging.add(db.currentTime());
        // ...
    }
}
```

## 풀이

내용은 동일하지만 기술적으로 많은 방법들이 있다.

### 방법 1

```java
class Database {
    // volatile를 추가하여 CPU 캐싱으로 인한 다른 객체 참조 방지
    private static volatile Database instance;
    private String currentTime = "";

    private Database() {
        // 생성자를 private로 만들어 생성을 불가능하도록 강제
    }

    public static Database getInstance() {
        // 만들어둔 게 없으면 새로운 객체 생성
        if (instance == null) {
            // 멀티 스레드에서의 버그 방지
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }
}
```

`Database` 객체를 가져오고 싶다면, `Database db = Database.getInstance()` 로 가져올 수 있으며 항상 같은 객체이다.

### 방법 2

```java
class Database {
    // 프로그램 시작부터 메모리에 떠있다.
    private static Database instance = new Database();
    private String currentTime = "";

    private Database() {
        // 생성자를 private로 만들어 생성을 불가능하도록 강제
    }

    public static Database getInstance() {
        // 다르게 생성되는 로직은 없으므로 항상 같은 객체
        return instance;
    }
}
```

`Database` 객체를 가져오고 싶다면, `Database db = Database.getInstance()` 로 가져올 수 있으며 항상 같은 객체이다.

### 방법 3

Java 5 이후 버전에 추가된 [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)을 사용하는 방법이다. 
현재까지 알려진 방법 중에는 가장 완벽하다고 알려진 방법이다.

(추가 예정)

## 참고

- https://refactoring.guru/ko/design-patterns/singleton
- https://dzone.com/articles/java-singletons-using-enum