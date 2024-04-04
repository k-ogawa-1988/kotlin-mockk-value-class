# Kotlin + mockk: Return type are not matched for ome value classes

## Run

```shell
./gradlew test
```

## Tests

### ValueGetterTest

[ValueGetterTest](./src/test/kotlin/com/example/ValueGetterTest.kt)

Just mock the return value of some function, then assert with original value.  
It happens `AssertionFailedError`.

```text
org.opentest4j.AssertionFailedError: expected: <LongValueClass(value=2)> but was: <2>
```

### ValueUseCaseTest

[ValueUseCaseTest](./src/test/kotlin/com/example/ValueUseCaseTest.kt)

```text
ValueUseCase
  |- ValueGetter         <-- inject a mock
  |    |- getLong()      <-- return fixed `LongValueClass` value by `coEvery`
  |    |_ getString()    <-- return fixed `StringValueClass` value by `coEvery`
  |_ ValueService        <-- inject a mock
       |_ modifyValue()  <-- return fixed value by `coEvery`
```

A use case class depends on 2 other classes. (Like Spring's constructor injection).  
Test class mocks those 2 classes, then instantiate `ValueUseCase` and call a method.  
It happens `ClassCastException`.

```text
java.lang.ClassCastException: class java.lang.Long cannot be cast to class com.example.LongValueClass (java.lang.Long is in module java.base of loader 'bootstrap'; com.example.LongValueClass is in unnamed module of loader 'app')
```
