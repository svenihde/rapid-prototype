<<<<<<< HEAD:JEngine-RoR/app/models/stages.rb
class Stages < ActiveRecord::Base
   serialize :completed
end
=======
class Stages < ActiveRecord::Base
   serialize :completed
   serialize :enabled
   serialize :open
   serialize :skipped
end
>>>>>>> version2:JEngine/app/models/stages.rb
