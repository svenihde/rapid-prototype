class ActivityController < ApplicationController
  #
  #
  def new
  end

  #
  #
  def create
	@Activity = Activity.new(activity_params)
	foo = @Activity.save
	if !foo
		puts 'error in saving activity into DB'
	end        
        redirect_to :action => 'done'
  end

  #
  #
  def done
  end

  #
  #
  def edit
  end

  #
  #
  private
	def activity_params
		params.require(:activity).permit(:title, :description)
	end	
end
