package com.hubspot.jinjava.objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Before;
import org.junit.Test;

public class NamespaceTest {
  private Namespace namespace;

  @Before
  public void setup() {
    namespace = new Namespace();
  }

  @Test
  public void shouldReturnNullIfValueDoNotExists() {
    // given
    String key = "key";

    // when
    final Object result = namespace.get(key);

    // then
    assertThat(result).isEqualTo(null);
  }

  @Test
  public void shouldReplaceValueForKeyIfValueForKeyExists() {
    // given
    String key = "key";
    namespace.put(key, Boolean.TRUE);
    namespace.put(key, "second value");

    // when
    final Object result = namespace.get(key);

    // then
    assertThat(result).isEqualTo("second value");
  }

  @Test
  public void shouldSetValueIfValueDoNotExists() {
    // given
    String key = "key";
    final String value = "Test";

    // when
    namespace.put(key, value);

    // then
    assertThat(namespace.get(key)).isEqualTo(value);
  }
}
