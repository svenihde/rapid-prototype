class Stages < ActiveRecord::Base
   serialize :completed
   serialize :enabled
   serialize :open
   serialize :skipped
end
