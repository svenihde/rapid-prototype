require 'test_helper'

class SetCookiesControllerTest < ActionController::TestCase
  test "should get show_cookies" do
    get :show_cookies
    assert_response :success
  end

  test "should get delete_cookies" do
    get :delete_cookies
    assert_response :success
  end

end
