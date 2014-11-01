class SetCookiesController < ApplicationController
  def show_cookies
  end

  def delete_cookies
      cookies.delete :cookie_id
  end
end
