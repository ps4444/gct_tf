terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

#using aws providers

provider "aws" {
    region = "us-east-1"
    access_key = ""
    secret_key = ""
}

# RSA key of size 4096 bits
resource "tls_private_key" "key_fr_tf" {
  algorithm = "RSA"
  rsa_bits  = 4096
}

resource "aws_key_pair" "tf_final_key" {
  key_name   = "insGCT_key"
  public_key = tls_private_key.key_fr_tf.public_key_openssh
}

resource "local_file" "private_key" {
  content  = "tls_private_key.key_fr_tf.private_key_pem"
  filename = "insGCT_key"
}
# launch a ec2 instnace


resource "aws_instance" "web_server_from_TF" {
  ami           = "ami-0fff1b9a61dec8a5f"
  instance_type = "t2.micro"
  key_name = aws_key_pair.tf_final_key.key_name
  tags = {
    Name = "test ins"
    }
}