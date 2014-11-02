# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#

#
# Including example Activities 
#
activities = Activity.create([{title: 'Brainstorming', kind: 'usertask', description: 'Think about Ideas to improve Something'},{title: 'Documentation', kind: 'usertask', description: 'Write down your Ideas on a paper'},{title: 'Communication', kind: 'usertask', description: 'Send your Documentation to your neighbor'}, {title: 'Feedback', kind: 'usertask', description: 'Wait for Feedback - at least 1 Minute'}, {title: 'FinishUp', kind: 'usertask', description: 'Delete all your notes'}])

#
# Including example Process 
#
# as array
#processes = Processes.create([{title: 'Knowledge Management', sequence: '["1", "2", "a", "5", "b"]', module: "['a' => ['type' => 'xor', 'activies' => '[['3'],['4']]'],'b' => ['type' => 'and', activies => '[['6','7'],['8']]'] ]", comments: 'pretty cool, wah?!',}])
# as hash
@hash = {
  "a" => {
    kind: "xor",
    "activities" => {{"3" => 0} => 0 , 
		     {"4" => 0} => 1}
  },
  "b" => {
    kind: "and",
    "activities" => {{"6" => 0,"7" => 1} => 0,
		              {"8" => 0} => 1}
  }
}

processes = Processes.create([{title: 'Knowledge Management', sequence: '{"1"=>0, "2"=>1, "a"=>2, "5"=>3, "b"=>4}', module: @hash, comments: 'pretty cool, wah?!',}])




