
def call(def firstname, def lastname) {
  overloading "${firstname} ${lastname}"
}

def call(def fullname) {
  println "Hello ${fullname}" 
}
