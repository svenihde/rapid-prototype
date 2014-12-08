class Processes < ActiveRecord::Base
	serialize :module, Hash
	serialize :sequence, Hash
end
