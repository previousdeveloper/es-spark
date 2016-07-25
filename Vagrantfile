# -*- mode: ruby -*-
# vi: set ft=ruby :
unless Vagrant.has_plugin?("vagrant-vbguest")
  raise "Missing vbguest plugin!
Run the following command:
  vagrant plugin install vagrant-vbguest"
end
# SCRIPT_PATH="https://raw.githubusercontent.com/gitphill/shell/master/"
SCRIPT_PATH = "../../../shell/"
Vagrant.configure(2) do |config|
  config.vm.box = "ubuntu/trusty64"
  config.vm.hostname = "spark.dev"
  config.vm.provider "virtualbox" do |vb|
    vb.name = "Spark Development"
    vb.memory = 4096
    vb.cpus = 2
  end
  config.vm.network :forwarded_port, host: 9200, guest: 9200
  config.vm.provision :shell do |sh|
    sh.path = SCRIPT_PATH + "start-in.sh"
    sh.args = ["vagrant", "/vagrant"]
  end
  config.vm.provision :shell do |sh|
    sh.path = SCRIPT_PATH + "docker.sh"
    sh.args = "vagrant"
  end
  config.vm.provision :shell, path: SCRIPT_PATH + "docker-compose.sh"
  config.vm.provision :shell, path: SCRIPT_PATH + "java-8.sh"
  config.vm.provision :shell, path: SCRIPT_PATH + "sbt.sh"
  config.vm.provision :shell, path: SCRIPT_PATH + "spark.sh"
end
