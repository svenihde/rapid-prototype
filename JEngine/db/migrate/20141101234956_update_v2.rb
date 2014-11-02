class UpdateV2 < ActiveRecord::Migration
  def change
	add_column :activities, :kind, :string
	add_column :stages, :skipped, :text
	add_column :stages, :processes, :text
	add_column :activities, :open, :text
	#change_column :activities, :completed, :text
	#change_column :activities, :enabled, :text

	drop_table :backgrounds
	drop_table :pcms
  end
end
