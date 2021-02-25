
def call(def firstname, def lastname) {
  call "${firstname} ${lastname}"
}

def call(def fullname) {
  println "Hello ${fullname}" 
}
