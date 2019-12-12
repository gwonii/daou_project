# Thinking Map 



## 1. 시시각각 달라지는 Action  (Not solved)

분 마다, 시간 마다, 날 마다 작동하는 동작들이 있다. 

이것을 멀티쓰레드로 사용해야 하는가? 



> 그런데 한 시간에 한 번씩 작동하는 것 대문에 멀티쓰레드를 쓸 필요는 없을 것 같은데...
>
> 근데 만약에 분마다 들어오는 request가 많다고 한다면 사용해야할 수도 있을 것 같다. 

---

<br>

## 2. RandomAccessFile class (Not solved)

RandomAccessFile은 어떻게 사용되어야 하는가..?



써야될 것 같다. 파일을 2019-12-05.txt 파일로 만들어져 그 안에 계속 데이터가 쌓인다. 

그런데 내가 분마다 들어오는 정보들을 읽어서 파일로 만들어야 하기 때문에, 

`RandomAccessFile`이 필요한 것이다. 

1분마다 한 파일에 새로 만들어지는 정보를 읽어야 한다. 

그 이전꺼는 읽지 않고 그렇기에 위 클래스가 필수적으로 필용한 것이다. 후....

이제 이해를 했다...

---

<br>

## 3. java 정규식 표현, regex  for Parsing  (#done#refactoring) 

과연 이 방법이 가장 효율적인 것인가? 

가독성,,, 효율성,,, 기타 등등



그래도 일단 우선은 regex를 이용하여 parsing을 해보도록 하자.

---

<br>

## 4. 변수를 넣은 regex (ING)



```
Oct 24 16:43:04 debian-logdna syslog  localhost
@ - - [2018-10-24 16:43:01.394735381 -0400 EDT]
"GET / HTTP/1.1" 302 96 "" "curl/7.52.1" 0.410829
```

를 위해서 

```
^Oct 19 [1][5-8]:[0-9]{2}:[0-9]{2}
```

이런식으로 표현할 수도 있다. 

---

<br>

## 5. Pattern의 정밀도는 어느 정도까지? (Not solved)

두 가지 선택지가 있다. 

**1.** 한 번에 IP주소를 다 받아오는 것 

```
"[\\d\\.]{1,15}"
```

**2. ** IP주소를 섹션별로 받아오는 것

``` 
"[\\d\\.]{1,3}" * 3
```

>일치형 판단에 있어서는 또 기준이 달라질 수 있다.......
>
>방식의 기준을 잡을 것! 



> 무엇이 좋을지 판단기준이 뭘지, 고민해봐야 할 것 같다. 

---

<br>

## 6. 예외처리 검증에 대해 어떻게 철저하게 할 수 있을까?? 

ex) HTTP method들에 대해 pattern을 만들면서, method별로 들어오는 url이 달라질 것으로 예상된다. 

위의 상황의 경우는 method가 정해져있고 method별로 필요한 값들이 정해져있기 때문에 예외 검증을

확실하게 할 수 있지만



이후에는 어떻게 예외처리를 철저히 검증할 수 있을까? 

<br>

**20191212 내용추가**

### Checked Exception 과 Unchecked Exception 

간단히 먼저 얘기하자면 

**Checked Exception**같은 경우는 컴파일 타임에 예외를 관리하기 때문에 반드시 exception 처리를 해야 된다. 

**Unchecked Exception**같은 경우는 런타임에 예외를 관리하기 때문에 필수적이지는 않다. 하지만 런타임에 생기는 예외를 제대로 관리하지 못하면 에러를 찾는데 어려움을 갖을 수 있다. 이런 Unchecked Exception을 위하여 Exception class를 만들어 관리하는 것이다. 

> https://itmining.tistory.com/9 
>
> 정리



---

<br>

## 7. log 하나를 regex로 통째로 parsing해야 할 지, 아니면 split 해놓고 parsing 할 지 (Not solved)





## 8. regex  VS search term



## **Better Performance**

Regex performs well enough for small searches, but **performance gets significantly worse as the search field grows and the expressions become more complex**. With log data, **regex** is often used on individual entries to parse fields and perform **real-time analysis**. However, using regex to search through gigabytes or terabytes of log data is incredibly slow and resource-intensive no matter how well optimized the expression is.

The challenge is writing expressions that are both **effective and efficient**. Our earlier example on searching hostnames takes 31 steps to complete. If we remove the anchor (^) at the start of the expression, the number of steps more than doubles. Inexperienced developers might use wildcards and lookarounds to add flexibility to their expressions without realizing the performance penalties that both of these incur. Catastrophic backtracking is a dangerous example of this and can even result in denial of service attacks.



> regex와 search term 효율성 테스트 해보기 

## **Conclusion**

Both regex and Google-like search terms are two of the most popular ways to search through log files to find what you’re looking for. **Regex syntax offers precision for users to pinpoint what they’re looking for but the tradeoff is the ramp-up time to learning how to craft what you need**. 

The second is the slower performance in large sets of log data and penalties in complex queries. Search terms provide speed, accessibility, and support for indexed data. This is how [LogDNA](https://logdna.com/)manages to provide blazing fast searches regardless of log volume. To learn more about how searching works in [LogDNA](https://logdna.com/), visit the [search documentation](https://docs.logdna.com/docs/search) or [sign into the LogDNA web app](https://app.logdna.com/).



## 9. parsing 해주는 클래스에서 구지 객체를 계속 생성할 필요가 있을까? 



parsingUtil을 모두 public static으로 구성하여 활용할 수 있게만 만들어야 겠다. 구지 계속 객체를 만들 필요는 없는 것을 같은데.... 



---

<br>



## 10. API 형식

API 형식이라고 생각하니까 거의다 객체를 만들어서 하는 것이 아니라 간단하게 api 쓰듯이 만들 수 있게 하면 좋을 것 같다. 





## 11. 다양한 paser Ref



```java
public List<Log> getLogFromFile(String file) throws IOException, ParseException {
        List<Log> logs = new ArrayList<>();
        Reader in = new FileReader(file);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withDelimiter('|').parse(in);
        for (CSVRecord record : records) {
            Log log = new Log();
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            String dateString = record.get(0);
            dateString = dateString.replace("\uFEFF", ""); // remove UTF BOM
            Date date = formatter.parse(dateString);
            log.setDate(date);

            log.setIp(record.get(1));
            log.setMethod(record.get(2));
            log.setResponse(record.get(3));
            log.setUserAgent(record.get(4));
            logs.add(log);
        }
        return logs;
    }

    public List<Log> find(Parameters params) throws ParseException{

        TypedQuery<Log> queryString = em.createQuery("SELECT l FROM log l " +
                        " WHERE l.date BETWEEN :startDate AND :endDate " +
                "GROUP BY l.ip HAVING count(l.ip) >= :threshold"
                , Log.class).
                setParameter("startDate", params.getStartDate()).
                setParameter("endDate", params.getEndDate()).
                setParameter("threshold", params.getThreshold());
        return queryString.getResultList();
    }

    public List<CommentLog> saveComments(Parameters params, List<Log> logs) {
        List<CommentLog> commentLogs = new ArrayList<>();
        logs.forEach(log -> {
            CommentLog commentLog = new CommentLog();
            commentLog.setIp(log.getIp());
            commentLog.setComment("The IP: " + log.getIp() + " has reached more than " + params.getThreshold().toString() +
            " requests between " + params.getStartDate().toString() + " and " + params.getEndDate().toString());
            commentLogs.add(commentLog);
        });
        commentLogRepository.save(commentLogs);
     return commentLogs;
    }
```





---

<br>



## 13. String[ ] 가 저장될 Queue의 형태는 어떻게 그려져야 할까? 





## 14. 각각의 로그는 객체로 저장되어 있을까...? (#warn)

갑자기 그래야 한다고 생각된다. 

동일한 형식의 item들이 있다. 

그 아이템들은 공통의 속성을 가지고 있다. 그리고 많은 수를 가지고 있다. 



단순히 객체가 많아진다고 문제가 생기는 것은 아니라고 생각된다. 

그렇다면 비교해야 하는 것은

배열로 저장해서 쓰는것..



생각해보니 객체는 재활용이 가능할 것 같다. 그렇다면 조금더 효율적으로 바꿀 수 있지 않을까? 



> 20191209 

로그 하나가 객체로 되어 있다면 필요한 정보들을 다 필드로 가지고 있을 수 있다. 



**BUT** 이렇게 다수의 객체를 생성하게 된다면 자원관리에 더 효율적이여야 하기 때문에 

좋지 않을 수 있다. 

## 15. split 다중 구분자

```
words = testRequest.split("\\s|\\[|\\]");
```

처럼 다중 구분자를 사용하는 경우

```
172.21.27.88
-
daoutest@terracetech.co.kr

25/Nov/2019:12:13:06
+0900

GET
/api/user/session
```

\\s와 [ 또는 ] 연속으로 있는 경우에는 2칸을 띈다.

어떻게 해결할 수 있을까?



**solution 1**

위 처럼 배열에 저장시킨 후에 "" 비어있는 String을 하나씩 수동으로 비워준다.

```
while(true) {
	System.out.println("삭제할 int 입력 : ");
        int delIdx = sc.nextInt();
        for(int i=delIdx; i<cnt-1; i++) {
             arr[i] = arr[i + 1];
        }
        cnt = cnt - 1;
}
```

이런식으로... 너무 무식한 것 같다.

**soluton 2**

단순 배열이 아닌 ArrayList 사용하기

그렇게 되면 빈 배열을 능독적으로 제거할 수 있다.



**solution 3** (#info)

지금 사용하고 있는 방식은 split을 통해 잘라낸 데이털르 string[ ]에 넣고 그것을 arrayList로 변환하는 방식으로 

사용하고 있다. 



그런데 바로 arrayList로 문자열을 자를 수 있을 것 같다. 이건 추후에 고칠 수 있도록



## 16. 현재의 parsing 

(#warn)

지금은 먼저 split을 통해 문자열을 자르고 각각 배열인덱스에 맞게 정규식을 이용하여 파싱하고 있다. 

하지만 이후에 로그의 형태가 변한다면 작동하지 않는다. 

이런 문제점을 해결할 수 있지 않을까??



## 17. 파일 저장하기 

이제 일자 파일, 시간 파일, 분 파일을 만들텐데... 

어떻게 출력해줘야 가장 저장하기 쉬울까 



1. 일단 시스템이 작동하면 전 날까지는 일자 파일에 모두 저장되어 있는다. 
2. 당일 날은 현재 시간 전까지는 시간 파일로 가지고 있고, 
3. 현재 시간은 분 파일로 가지고 있다. 



## 18. Time parsing



## 19. RegexParsingUtil 

이 클래스를 상속받아 오버로딩하는 클래스들을 만들 수 있을 것 같다. 



## 20. timeDetail의 정보들

timeDetail의 정보들은 time정보들을 나눈 detail한 정보들을 가리킨다. 

잘라진 각각의 데이터들은 모두 String이다. 

//

1. 이것을 int로 바꿔서 처리하는 것이 좋을까? 

2. 아니면 그냥 String으로 계속 처리하는 것이 좋을가?



효율적인 측면에서는 1번이 좋은 것 같고 간편한 측면에서는 2번이 괜찮을 것 같다. ... 

1번이 좋다는 것이겠지.. 후

하지만 1번으로 한다면 String을 int로 바꿔야 하는 과정이 존재한다. 그냥 단순히 하나의 데이터를

변경시킬 때는 크게 문제 되지 않겠지만, 막대한 정보의 데이터라면??? 



## 21. 필드 변수는 필요할 때 사용해라

현재 여러 메소드에서 사용하지 않음에도 불구하고 클래스 필드에 변수를 선언하고 있다.

만약에 하나의 메소드에서만 사용되는 것이라면, 지역 변수로 바꿔라.

그래야 자원을 조금더 아낄 수 있다.



## 22. log를 저장한다면, 

로그를 뽑아내고 바로 사용하는 것이 아니라, 

내 변수에 저장을 시켜놓는다면, String이 좋을까 Log라는 객체가 좋을까



그런데 어차피 한 줄의 log정보를 받아서 파일에 저장할 것이기 때문에 바로 바로 하는게 좋을 것 같으면서도 

그런데 위와 같이 parsing한 log정보를 저장하지 않고 바로 사용하게 되면, 나중에 다시 읽는 시간을 갖게 될 수 있지 않을까 그렇다면 저장해놓는 것이 좋을 것 같다. 왜냐하면 **자원의 문제보다 시간의 문제가 더 중요하다고 생각한다.** 



## 23. try - catch 문이 아니라 try - with - resource를 사용해라 





## 24. 파일 read 후 write 순서에 관해서 

현재 한 줄을 읽고 객체의 형태로 저장을 시키고 있다. 

그러면 바로바로 한 줄 씩읽으면서 텍스트에 글을 작성해야할까? 

아니면 저장시켜 놓은 객체 리스트를 나중에 다시 순회할까? 



어차피 나중에 텍스트를 또 읽어야 한다면 쓸 때는 바로바로 쓰는게 좋지 않을까?? 



## 25. model과 controller는 분명하게 구분할 것

기존의 클래스는 크게 FTPConnection, RegexParsing, FileSave로 되어있다. 

하지만 이 세 클래스는 모두 환경과 행동이 모두 담겨있다. 행동은 행동만 하고, 환경들은 환경끼리만 모여 있어야 한다. 





## 26. 가변 매개인자 사용하기 

몇개의 매개변수가 들어올지 모를 때 사용할 수 있다. 

```java
void sum(String...str) {
        for(String a:str)
            System.out.println(a);
}
```

이런식으로 사용할 수 있다. 



## 27.자바 버전에 따른 변화된 기능들 

java 8 : 람다식 

java 9 : try - with - resource 향상

java 10 : 지역변수 var 선언



기타 

옵저버 패턴

제네릭 



## 28. 옵저버 패턴을 이용한 실시간 로그 데이터 읽기



## 29. test하기 given, when, then



## 30. 객체지향 설계 원칙

1. **SRP** : 단일 책임 원칙
2. **OCP** : 개방 폐쇄 원칙
3. **LSP** : 리스코프 이환원칙
4. **ISP** : 인터페이스 분리원칙
5. **DIP** : 의존관계 역전원칙



개방폐쇄 원칙 : 높은 응집도와 낮은 결합도.... 



## 31. 목적과 상황에 맞게 변수 타입을 정의할 것 

처음에 parsing하기 편하게 시간에 대해서 모두 String으로 받았는데, 

그것을 현재시간과 비교하는데 있어서 계속 String을 int로 변경해야 하는 불편함이 있다. 

logModel에서 자체적으로 int로 받을 수 있게 만들자. 



## 32. Enum 사용기



## 33. Lombok 사용기



## 34. 역할과 책임이란? 



## 35. 객체 지향적 설계

* 클래스 우선이 아닌, 객체의 속성과 행위가 우선이다. \
* 데이터가 아닌 메시지(행위)를 중심으로 객체를 설계하라
  * 객체는 혼자 있을 수 없다. 다른 객체와의 **협력** 안에서만 존재할 수 있다.
  * 메세지를 중심으로, 해당 메세지가 어떤 객체를 필요로 하는지를 생각하자. 
* 하나의 메소드는 하나의 일만 한다. 



## 36. 내 프로그램의 객체들은 무엇이 있을까? (#error)





## Q1. 

전체 저장된 데이터는 어떻게 검증할 수 있을까?? 