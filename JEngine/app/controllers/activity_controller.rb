class ActivityController < ApplicationController
  def new
	#puts 'adding activity'
  end
  def create
	# Printing form post parameters	
	#render plain: params[:activity].inspect

	@Activity = Activity.new(activity_params)
	foo = @Activity.save
	if !foo
		puts 'error in saving activity into DB'
	end        
        redirect_to :action => 'done'
  end
  def done
  end
  def edit
	#task_id =
	#puts 'editing activity'
  end

  private
	def activity_params
		params.require(:activity).permit(:title, :description)
	end	
end
