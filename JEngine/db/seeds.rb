# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
activities = Activity.create([{title: 'Brainstorming', a_type: 'user_task', description: 'Think about Ideas to improve Something'},{title: 'Documentation', a_type: 'user_task', description: 'Write down your Ideas on a paper'},{title: 'Communication', a_type: 'user_task', description: 'Send your Documentation to your neighbor'}, {title: 'Feedback', a_type: 'user_task', description: 'Wait for Feedback - at least 1 Minute'}, {title: 'FinishUp', a_type: 'user_task', description: 'Delete all your notes'}])
