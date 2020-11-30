package com.centime.oidc.constants;

//TODO: Rename /Refactor this to specific service exception code
/**
 * The enum Template service exception code.
 */
public enum TemplateServiceExceptionCode {

  /**
   * String mismatch exception Code
   */
  STRING_MISMATCH("ST001");

  private final String code;

  TemplateServiceExceptionCode(final String code) {
    this.code = code;
  }

  /**
   * Gets code.
   * @return the code
   */
  public String getCode() {
    return this.code;
  }
}
