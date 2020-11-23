package com.centime.demo.util;

import com.centime.enums.StatusEnum;
import com.centime.model.common.Response;

public class ResponseUtil {

  private ResponseUtil() {
    // private no args constructor to override the default constructor.
  }

  /**
   * Generate success response response.
   * @param <T>
   *          the type parameter
   * @param data
   *          the data
   * @return the response
   */
  public static <T> Response<T> generateSuccessResponse(T data) {
    Response<T> response = generateSuccessResponse();
    response.setData(data);
    return response;

  }

  /**
   * Generate success response response.
   * @param <T>
   *          the type parameter
   * @return the response
   */
  public static <T> Response<T> generateSuccessResponse() {
    Response<T> response = new Response<>();
    response.setStatus(StatusEnum.SUCCESS);
    return response;

  }
}
